package io.kurumi.mcio.cmd.content.header

import cn.hutool.core.util.StrUtil

enum class CmdMessage(val type: String) {

    /**
     * 命令请求
     * 发送命令使用的类型
     */
    CommandRequest("commandRequest"),

    /**
     * 注册事件
     */
    Subscribe("subscribe"),

    /**
     * 取消注册事件
     */
    UnSubscribe("unsubscribe"),

    /**
     * 命令回复
     */
    CommandResponse("commandResponse"),

    /**
     * 错误信息
     * 可能是命令的? 未测试
     */
    Error("printError"),

    /**
     * 收到的事件
     */
    Event("event");


    override fun toString(): String {
        return type
    }

    companion object {

        fun keyTrans(name : String) : String {

            return StrUtil.upperFirst(name)

        }

    }

}