package io.kurumi.util

import cn.hutool.core.io.FileUtil
import io.kurumi.arrayTrans
import io.kurumi.platform.取实现
import io.kurumi.service.abs.文件服务
import io.kurumi.service.服务类型
import java.io.File

class 文件 private constructor(internal val _文件: File) {

    val 名称 get() = _文件.name
    val 地址 get() = _文件.path

    val 存在 get() = _文件.exists()
    val 是文件 get() = _文件.isFile
    val 是目录 get() = _文件.isDirectory

    var 可读
        get() = _文件.canRead()
        set(value) {
            _文件.setReadable(value)
        }

    var 可写
        get() = _文件.canWrite()
        set(value) {
            _文件.setWritable(value)
        }

    var 可执行
        get() = _文件.canExecute()
        set(value) {
            _文件.setExecutable(value)
        }

    val 去扩展名 get() = _文件.nameWithoutExtension
    val 扩展名 get() = _文件.extension

    val 子文件 get() = _文件.listFiles().arrayTrans { 取实例(this) }

    var 字节
        get() = FileUtil.readBytes(_文件)
        set(value) {
            FileUtil.writeBytes(value, _文件)
        }

    var 字符
        get() = String(字节)
        set(value) {
            FileUtil.writeUtf8String(value, _文件)
        }

    val 输入流 get() = FileUtil.getInputStream(_文件)
    val 输出流 get() = FileUtil.getOutputStream(_文件)

    var 最后修改时间
        get() = _文件.lastModified()
        set(value) {
            _文件.setLastModified(value)
        }

    fun 删除(): Boolean {
        return FileUtil.del(_文件)
    }

    fun 新建(): Boolean {
        return if (!_文件.isFile) FileUtil.newFile(_文件.path).isFile else true
    }

    fun 子文件(_地址: String): 文件 {
        return 取实例("$地址/$_地址")
    }

    companion object : 文件服务 by 服务类型.文件.取实现() {

        private val 实例 = HashMap<String, 文件>()

        fun 取实例(_文件: File): 文件 {
            return if (实例.containsKey(_文件.path)) 实例.get(_文件.path)!! else 实例.put(_文件.path, 文件(_文件))!!
        }

        fun 取实例(_地址: String): 文件 {
            return 取实例(FileUtil.file(_地址))
        }

        fun 删除(_地址: String): Boolean {
            return FileUtil.del(_地址)
        }

        fun 复制(_地址: String, _新地址: String, _覆盖: Boolean): 文件 {
            return 取实例(FileUtil.copy(_地址, _新地址, _覆盖))
        }

        fun 新建(_地址: String): 文件 {
            return 取实例(FileUtil.newFile(_地址))
        }

        fun 目录(_地址: String): 文件 {
            return 取实例(FileUtil.mkdir(_地址))
        }

        fun 上级(_地址: String): 文件 {
            return 取实例(FileUtil.mkParentDirs(_地址))
        }

        fun 取子文件(_地址: String): Array<文件> {
            return 取实例(_地址).子文件
        }

    }

}