package io.kurumi.net

import cn.hutool.core.util.CharsetUtil
import java.io.*
import java.net.Socket
import java.net.SocketException
import java.nio.BufferUnderflowException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.Charset
import java.util.*

class RconClient(val host: String, val port: Int, val pswd: String) {

    private val rand = Random()
    private var requestId: Int = 0
    private var socket: Socket? = null
    var charset: Charset = CharsetUtil.CHARSET_UTF_8

    fun connect(): Boolean {

        synchronized(this) {
            // New random request id
            this.requestId = rand.nextInt()
            this.socket = Socket(host, port)
        }

        val res = this.send(RconPacket.SERVERDATA_AUTH, pswd.toByteArray())

        // Auth failed
        return res.requestId != -1

    }


    fun disconnect() {
        synchronized(this) {
            this.socket?.close()
        }
    }

    fun exec(payload: String): String {
        val response = this.send(RconPacket.SERVERDATA_EXECCOMMAND, payload.toByteArray())
        return String(response.payload, this.charset)
    }

    private fun send(type: Int, payload: ByteArray): RconPacket {
        synchronized(this) {
            return RconPacket.send(this, type, payload)
        }
    }


    class RconPacket private constructor(val requestId: Int, val type: Int, val payload: ByteArray) {
        companion object {

            val SERVERDATA_EXECCOMMAND = 2
            val SERVERDATA_AUTH = 3

            fun send(rcon: RconClient, type: Int, payload: ByteArray): RconPacket {
                try {
                    write(rcon.socket!!.getOutputStream(), rcon.requestId, type, payload)
                } catch (se: SocketException) {
                    // Close the socket if something happens
                    rcon.socket?.close()

                    // Rethrow the exception
                    throw se
                }

                return read(rcon.socket!!.getInputStream())
            }

            /**
             * Write a rcon packet on an outputstream
             *
             * @param out The OutputStream to write on
             * @param requestId The request id
             * @param type The packet type
             * @param payload The payload
             *
             * @throws IOException
             */
            @Throws(IOException::class)
            private fun write(out: OutputStream, requestId: Int, type: Int, payload: ByteArray) {
                val bodyLength = getBodyLength(payload.size)
                val packetLength = getPacketLength(bodyLength)

                val buffer = ByteBuffer.allocate(packetLength)
                buffer.order(ByteOrder.LITTLE_ENDIAN)

                buffer.putInt(bodyLength)
                buffer.putInt(requestId)
                buffer.putInt(type)
                buffer.put(payload)

                // Null bytes terminators
                buffer.put(0.toByte())
                buffer.put(0.toByte())

                // Woosh!
                out.write(buffer.array())
                out.flush()
            }


            @Throws(IOException::class)
            private fun read(`in`: InputStream): RconPacket {
                // Header is 3 4-bytes ints
                val header = ByteArray(4 * 3)

                // Read the 3 ints
                `in`.read(header)

                try {
                    // Use a bytebuffer in little endian to read the first 3 ints
                    val buffer = ByteBuffer.wrap(header)
                    buffer.order(ByteOrder.LITTLE_ENDIAN)

                    val length = buffer.int
                    val requestId = buffer.int
                    val type = buffer.int

                    // Payload size can be computed now that we have its length
                    val payload = ByteArray(length - 4 - 4 - 2)

                    val dis = DataInputStream(`in`)

                    // Read the full payload
                    dis.readFully(payload)

                    // Read the null bytes
                    dis.read(ByteArray(2))

                    return RconPacket(requestId, type, payload)
                } catch (e: BufferUnderflowException) {
                    throw RuntimeException("Cannot read the whole packet")
                } catch (e: EOFException) {
                    throw RuntimeException("Cannot read the whole packet")
                }

            }

            private fun getPacketLength(bodyLength: Int): Int {
                // 4 bytes for length + x bytes for body length
                return 4 + bodyLength
            }

            private fun getBodyLength(payloadLength: Int): Int {
                // 4 bytes for requestId, 4 bytes for type, x bytes for payload, 2 bytes for two null bytes
                return 4 + 4 + payloadLength + 2
            }
        }

    }


}
