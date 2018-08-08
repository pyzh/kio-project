package io.kurumi.mcio.cmd

import io.kurumi.mcio.cmd.content.CmdResult
import java.util.concurrent.atomic.AtomicReference

@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
class CmdResp(val manager: CmdManager, val id: String) {

    val getted = AtomicReference<CmdResult>()

    fun wait(): CmdResult {

        synchronized(this) {

            manager.waiting.put(id,this)

            (this as java.lang.Object).wait(5000)

            return getted.get()

        }

    }

    fun ret(res: CmdResult) {

        synchronized(this) {

            getted.set(res)

            manager.waiting.remove(id)

            (this as java.lang.Object).notifyAll()

        }

    }

}