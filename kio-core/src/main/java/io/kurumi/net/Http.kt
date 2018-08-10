package io.kurumi.net

import cn.hutool.core.io.resource.Resource
import cn.hutool.core.util.StrUtil
import cn.hutool.http.Header
import cn.hutool.http.HttpRequest
import cn.hutool.http.HttpUtil
import cn.hutool.http.Method
import cn.hutool.json.JSON
import java.io.File
import java.net.HttpCookie
import java.net.Proxy
import java.nio.charset.Charset
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSocketFactory

class Http : HttpRequest {

    companion object : HttpUtil() {

        const val jsonContentType = "application/json"

        fun getPublicIp(): String? {

            val str = get("https://ip.cn")

            return StrUtil.subBetween(str, "您现在的 IP：<code>", "</code>")

        }

        fun getPublicAddress(): String? {

            val str = get("https://ip.cn")

            return StrUtil.subBetween(str, "所在地理位置：<code>", "</code>")

        }

    }

    constructor(url: String) : super(url)

    constructor(method: Method, url: String) : this(url) {
        method(method)
    }


    fun json(jsonString: String): Http {
        body(jsonString, jsonContentType)
        return this
    }

    fun json(json: JSON): Http {
        body(json.toString(), jsonContentType)
        return this
    }

    override fun timeout(milliseconds: Int): Http {
        super.timeout(milliseconds)
        return this
    }

    override fun removeHeader(name: String?): Http {
        super.removeHeader(name)
        return this
    }

    override fun removeHeader(name: Header?): Http {
        super.removeHeader(name)
        return this
    }

    override fun body(body: String?): Http {
        super.body(body)
        return this
    }

    override fun body(body: String?, contentType: String?): Http {
        super.body(body, contentType)
        return this
    }

    override fun body(json: JSON?): Http {
        super.body(json)
        return this
    }

    override fun body(bodyBytes: ByteArray?): Http {
        super.body(bodyBytes)
        return this
    }

    override fun contentLength(value: Int): Http {
        super.contentLength(value)
        return this
    }

    override fun enableDefaultCookie(): Http {
        super.enableDefaultCookie()
        return this
    }

    override fun method(method: Method?): Http {
        super.method(method)
        return this
    }

    override fun setSSLProtocol(protocol: String?): Http {
        super.setSSLProtocol(protocol)
        return this
    }

    override fun addHeaders(headers: MutableMap<String, String>?): Http {
        super.addHeaders(headers)
        return this
    }

    override fun basicAuth(username: String?, password: String?): Http {
        super.basicAuth(username, password)
        return this
    }

    override fun httpVersion(httpVersion: String?): Http {
        super.httpVersion(httpVersion)
        return this
    }

    override fun cookie(vararg cookies: HttpCookie?): Http {
        super.cookie(*cookies)
        return this
    }

    override fun cookie(cookie: String?): Http {
        super.cookie(cookie)
        return this
    }

    override fun setHostnameVerifier(hostnameVerifier: HostnameVerifier?): Http {
        super.setHostnameVerifier(hostnameVerifier)
        return this
    }

    override fun setMaxRedirectCount(maxRedirectCount: Int): Http {
        super.setMaxRedirectCount(maxRedirectCount)
        return this
    }

    override fun setEncodeUrl(isEncodeUrl: Boolean): Http {
        super.setEncodeUrl(isEncodeUrl)
        return this
    }

    override fun setFollowRedirects(isFollowRedirects: Boolean): Http {
        super.setFollowRedirects(isFollowRedirects)
        return this
    }

    override fun keepAlive(isKeepAlive: Boolean): Http {
        super.keepAlive(isKeepAlive)
        return this
    }

    override fun setSSLSocketFactory(ssf: SSLSocketFactory?): Http {
        super.setSSLSocketFactory(ssf)
        return this
    }

    override fun charset(charset: String?): Http {
        super.charset(charset)
        return this
    }

    override fun charset(charset: Charset?): Http {
        super.charset(charset)
        return this
    }

    override fun form(name: String?, value: Any?): Http {
        super.form(name, value)
        return this
    }

    override fun form(name: String?, value: Any?, vararg parameters: Any?): Http {
        super.form(name, value, *parameters)
        return this
    }

    override fun form(formMap: MutableMap<String, Any>?): Http {
        super.form(formMap)
        return this
    }

    override fun form(name: String?, vararg files: File?): Http {
        super.form(name, *files)
        return this
    }

    override fun form(name: String?, file: File?): Http {
        super.form(name, file)
        return this
    }

    override fun form(name: String?, file: File?, fileName: String?): Http {
        super.form(name, file, fileName)
        return this
    }

    override fun form(name: String?, fileBytes: ByteArray?, fileName: String?): Http {
        super.form(name, fileBytes, fileName)
        return this
    }

    override fun form(name: String?, resource: Resource?): Http {
        super.form(name, resource)
        return this
    }

    override fun contentType(contentType: String?): Http {
        super.contentType(contentType)
        return this
    }

    override fun setProxy(proxy: Proxy?): Http {
        super.setProxy(proxy)
        return this
    }

    override fun header(name: String?, value: String?, isOverride: Boolean): Http {
        super.header(name, value, isOverride)
        return this
    }

    override fun header(name: Header?, value: String?, isOverride: Boolean): Http {
        super.header(name, value, isOverride)
        return this
    }

    override fun header(name: Header?, value: String?): Http {
        super.header(name, value)
        return this
    }

    override fun header(name: String?, value: String?): Http {
        super.header(name, value)
        return this
    }

    override fun header(headers: MutableMap<String, MutableList<String>>?): Http {
        super.header(headers)
        return this
    }

    override fun header(headers: MutableMap<String, MutableList<String>>?, isOverride: Boolean): Http {
        super.header(headers, isOverride)
        return this
    }

    override fun disableCookie(): Http {
        super.disableCookie()
        return this
    }

    override fun disableCache(): Http {
        super.disableCache()
        return this
    }
}