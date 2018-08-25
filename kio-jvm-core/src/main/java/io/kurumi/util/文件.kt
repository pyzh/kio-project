package io.kurumi.util

import cn.hutool.core.io.FileUtil
import io.kurumi.arrayTrans
import io.kurumi.service.实现
import io.kurumi.service.文件服务
import java.io.File

class 文件 private constructor(val 文件: File) {

    val 名称 get() = 文件.name
    val 地址 get() = 文件.path

    val 存在 get() = 文件.exists()
    val 是文件 get() = 文件.isFile
    val 是目录 get() = 文件.isDirectory

    var 可读
        get() = 文件.canRead()
        set(value) {
            文件.setReadable(value)
        }

    var 可写
        get() = 文件.canWrite()
        set(value) {
            文件.setWritable(value)
        }

    var 可执行
        get() = 文件.canExecute()
        set(value) {
            文件.setExecutable(value)
        }

    val 去扩展名 get() = 文件.nameWithoutExtension
    val 扩展名 get() = 文件.extension

    val 子文件 get() = 文件.listFiles().arrayTrans { 取实例(this) }

    var 字节
        get() = FileUtil.readBytes(文件)
        set(value) {
            FileUtil.writeBytes(value, 文件)
        }

    var 字符
        get() = String(字节)
        set(value) {
            FileUtil.writeUtf8String(value, 文件)
        }

    val 输入流 get() = FileUtil.getInputStream(文件)
    val 输出流 get() = FileUtil.getOutputStream(文件)

    var 最后修改时间
        get() = 文件.lastModified()
        set(value) {
            文件.setLastModified(value)
        }

    fun 删除(): Boolean {
        return FileUtil.del(文件)
    }

    fun 目录(): 文件 {
        目录(文件.path)
        return this
    }

    fun 上级(): 文件 {
        上级(文件.path)
        return this
    }

    fun 新建(): Boolean {
        if (!文件.exists()) {
            上级()
            try {
                文件.createNewFile()
            } catch (ignored: Exception) {
                return false
            }
        }
        return true
    }

    fun 子文件(_地址: String): 文件 {
        return 取实例("$地址/$_地址")
    }

    fun 打开() {
        打开(this)
    }

    companion object : 文件服务 by 文件服务::class.实现 {

        private val 实例 = HashMap<String, 文件>()

        fun 取实例(文件: File): 文件 {
            if (!实例.containsKey(文件.path)) {
                实例.put(文件.path, 文件(文件))
            }
            return 实例.get(文件.path)!!
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