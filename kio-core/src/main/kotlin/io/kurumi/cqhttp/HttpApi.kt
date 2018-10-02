/*
 * Copyright 2018 MikaGuraNTK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.kurumi.cqhttp

import io.kurumi.core.连接
import io.kurumi.core.连接工厂
import io.kurumi.data.JSON

class HttpApi(val host : String,val accessToken : String? = null) {

    companion object {

        // 发送
        const val SEND_PRIVATE_MSG = "send_private_msg"
        const val SEND_GROUP_MSG = "send_group_msg"
        const val SEND_DISCUSS_MSG = "send_discuss_msg"
        const val SEND_LIKE = "send_like"

        // 撤回消息
        const val DELETE_MSG = "delete_msg"

        // 群操作
        const val SET_GROUP_KICK = "set_group_kick"
        const val SET_GROUP_BAN = "set_group_ban"
        const val SET_GROUP_ANONYMOUS_BAN = "set_group_anonymous_ban"
        const val SET_GROUP_WHOLE_BAN = "set_group_whole_ban"
        const val SET_GROUP_ADMIN = "set_group_admin"
        const val SET_GROUP_ANONYMOUS = "set_group_anonymous"
        const val SET_GROUP_CARD = "set_group_card"
        const val SET_GROUP_LEAVE = "set_group_leave"
        const val SET_GROUP_SPECIAL_TITLE = "set_group_special_title"
        const val SET_DISCUSS_LEAVE = "set_discuss_leave"
        const val SET_FRIEND_ADD_REQUEST = "set_friend_add_request"
        const val SET_GROUP_ADD_REQUEST = "set_group_add_request"

        // ICQ(酷Q, 以及HTTP插件)设置区
        const val SET_RESTART = "set_restart"
        const val SET_RESTART_PLUGIN = "set_restart_plugin"
        const val CLEAN_DATA_DIR = "clean_data_dir"
        const val CLEAN_PLUGIN_LOG = "clean_plugin_log"

        // 应用内获取区
        const val GET_LOGIN_INFO = "get_login_info"
        const val GET_STRANGER_INFO = "get_stranger_info"
        const val GET_GROUP_LIST = "get_group_list"
        const val GET_GROUP_MEMBER_INFO = "get_group_member_info"
        const val GET_GROUP_MEMBER_LIST = "get_group_member_list"
        const val GET_FRIEND_LIST = "_get_friend_list"


        // ICQ(酷Q, 以及HTTP插件)获取区
        const val GET_VERSION_INFO = "get_version_info"
        const val GET_STATUS = "get_status"
        const val SEND_MSG = "send_msg"

        // 4.3.1新增
        const val GET_VIP_INFO = "_get_vip_info ";
    }

    private val 工厂 = 连接工厂 {

        连接("$host/$it").apply {

            方法 = "POST"

            if (accessToken != null) {

                请求头("Authorization",accessToken)

            }

        }

    }

    fun sendRequest(path: String, async: Boolean, vararg params: Any): 连接.结果 {

        val request = 工厂.新建("$path${if (async) "_async" else ""}")
        request.参数(JSON(formatParams(params)))
        return request.同步()

    }


    /**
     * 发送私聊消息
     * @param qq      QQ号
     * @param message 消息
     * @param autoEscape 是否纯文本发送
     */
    fun sendPrivateMsg(qq: Long, message: String, autoEscape: Boolean = false, async: Boolean = false): LocalMsg {
        return sendRequest(SEND_PRIVATE_MSG, async, "user_id", qq, "message", message, "auto_escape", autoEscape).toMsgResp()
    }

    /**
     * 发送群聊消息
     * @param groupId 群ID
     * @param message 消息
     * @param autoEscape 是否纯文本发送
     */
    @JvmOverloads
    fun sendGroupMsg(groupId: Long, message: String, autoEscape: Boolean = false, async: Boolean = false): LocalMsg {
        return sendRequest(SEND_GROUP_MSG, async, "group_id", groupId, "message", message, "auto_escape", autoEscape).toMsgResp()
    }

    /**
     * 发送讨论组消息
     * @param groupId 讨论组ID
     * @param message 消息
     * @param autoEscape 是否纯文本发送
     */
    @JvmOverloads
    fun sendDiscussMsg(groupId: Long, message: String, autoEscape: Boolean = false, async: Boolean = false): LocalMsg {
        return sendRequest(SEND_DISCUSS_MSG, async, "discuss_id", groupId, "message", message, "auto_escape", autoEscape).toMsgResp()
    }

    /**
     * 撤回消息
     * @param messageId 消息ID
     */
    fun deleteMsg(messageId: Long, async: Boolean = false): UnitResp {
        return sendRequest(DELETE_MSG, async, "message_id", messageId).toUnitResp()
    }

    /**
     * 发送好友赞
     * @param qq    QQ号
     * @param times 赞的次数，每个好友每天最多 10 次
     */
    fun sendLike(qq: Long, times: Long, async: Boolean = false): UnitResp {
        return sendRequest(SEND_LIKE, async, "user_id", qq, "times", times).toUnitResp()
    }

    /**
     * 群组踢人
     * @param groupId 群号
     * @param qq      QQ
     * @param rejectFurtherRequest 拒绝这个人的加群请求
     */
    fun setGroupKick(groupId: Long, qq: Long, rejectFurtherRequest: Boolean = false, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_KICK, async, "user_id", qq, "group_id", groupId, "reject_and_request", rejectFurtherRequest).toUnitResp()
    }

    /**
     * 群组单人禁言
     * @param groupId  群号
     * @param qq       QQ
     * @param duration 禁言时长，单位秒，0 表示取消禁言
     */

    fun setGroupBan(groupId: Long, qq: Long, duration: Long, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_BAN, async, "user_id", qq, "group_id", groupId, "duration", duration).toUnitResp()
    }

    /**
     * 群组匿名用户禁言
     * @param flag     要禁言的匿名用户的 flag（需从群消息上报的数据中获得）
     * @param groupId  群号
     * @param duration 禁言时长，单位秒，无法取消匿名用户禁言
     */
    fun setGroupAnonymousBan(flag: String, groupId: Long, duration: Long, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_ANONYMOUS_BAN, async, "flag", flag, "group_id", groupId, "duration", duration).toUnitResp()
    }

    /**
     * 群组全员禁言
     * @param groupId 群号
     * @param enable  是否禁言
     */
    fun setGroupWholeBan(groupId: Long, enable: Boolean, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_WHOLE_BAN, async, "group_id", groupId, "enable", enable).toUnitResp()
    }

    /**
     * 群组设置管理员
     * @param groupId 群号
     * @param qq      要设置管理员的 QQ 号
     * @param enable  true 为设置，false 为取消
     */
    fun setGroupAdmin(groupId: Long, qq: Long, enable: Boolean, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_ADMIN, async, "group_id", groupId, "user_id", qq, "enable", enable).toUnitResp()
    }

    /**
     * 群组设置匿名
     * @param groupId 群号
     * @param enable  是否允许匿名聊天
     */
    fun setGroupAnonymous(groupId: Long, enable: Boolean, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_ANONYMOUS, async, "group_id", groupId, "enable", enable).toUnitResp()
    }

    /**
     * 设置群名片（群备注）
     * @param groupId 群号
     * @param qq      要设置的 QQ 号
     * @param card  群名片内容，不填或空字符串表示删除群名片
     */
    fun setGroupCard(groupId: Long, qq: Long, card: String, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_CARD, async, "group_id", groupId, "user_id", qq, "card", card).toUnitResp()
    }

    /**
     * 退出群组
     * @param groupId 群号
     * @param dismiss 是否解散，如果登录号是群主，则仅在此项为 true 时能够解散
     */
    fun setGroupLeave(groupId: Long, dismiss: Boolean, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_LEAVE, async, "group_id", groupId, "is_dismiss", dismiss).toUnitResp()
    }

    /**
     * 设置群组专属头衔
     * @param groupId 群号
     * @param qq 要设置的QQ号
     * @param specialTitle 专属头衔，不填或空字符串表示删除专属头衔
     */
    fun setGroupSpecialTitle(groupId: Long, qq: Long, specialTitle: String, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_SPECIAL_TITLE, async, "group_id", groupId, "user_id", qq, "special_title", specialTitle).toUnitResp()
    }

    /**
     * 设置群组专属头衔
     * @param groupId 群号
     * @param qq 要设置的QQ号
     * @param specialTitle 专属头衔，不填或空字符串表示删除专属头衔
     * @param duration 专属头衔有效期，单位秒，-1 表示永久，不过此项似乎没有效果，可能是只有某些特殊的时间长度有效，有待测试
     */
    fun setGroupSpecialTitle(groupId: Long, qq: Long, specialTitle: String, duration: Long, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_SPECIAL_TITLE, async, "group_id", groupId, "user_id", qq, "special_title", specialTitle, "duration", duration).toUnitResp()
    }

    /**
     * 退出讨论组
     * @param discussId 讨论组 ID（正常情况下看不到，需要从讨论组消息上报的数据中获得）
     */
    fun setDiscussLeave(discussId: Long, async: Boolean = false): UnitResp {
        return sendRequest(SET_DISCUSS_LEAVE, async, "discuss_id", discussId).toUnitResp()
    }

    /**
     * 处理加好友请求
     * @param flag 加好友请求的 flag（需从上报的数据中获得）
     * @param approve 是否同意请求
     */
    fun setFriendAndRequest(flag: String, approve: Boolean, async: Boolean = false): UnitResp {
        return sendRequest(SET_FRIEND_ADD_REQUEST, async, "flag", flag, "approve", approve).toUnitResp()
    }

    /**
     * 处理加好友请求
     * @param flag 加好友请求的 flag（需从上报的数据中获得）
     * @param approve 是否同意请求
     * @param remark 添加后的好友备注（仅在同意时有效）
     */
    fun setFriendAndRequest(flag: String, approve: Boolean, remark: String, async: Boolean = false): UnitResp {
        return sendRequest(SET_FRIEND_ADD_REQUEST, async, "flag", flag, "approve", approve, "remark", remark).toUnitResp()
    }

    /**
     * 处理加群请求／邀请
     * @param flag 加好友请求的 flag（需从上报的数据中获得）
     * @param type add 或 invite，请求类型（需要和上报消息中的 sub_type 字段相符）
     * @param approve 是否同意请求／邀请
     * @param reason 拒绝理由（仅在拒绝时有效）
     */
    fun setGroupAndRequest(flag: String, type: String, approve: Boolean, reason: String, async: Boolean = false): UnitResp {
        return sendRequest(SET_GROUP_ADD_REQUEST, async, "flag", flag, "type", type, "approve", approve, "reason", reason).toUnitResp()
    }

    /**
     * 同意加群请求／邀请
     * @param flag 加好友请求的 flag（需从上报的数据中获得）
     * @param type add 或 invite，请求类型（需要和上报消息中的 sub_type 字段相符）
     */
    fun approveGroupRequest(flag: String, type: String, async: Boolean = false): UnitResp {
        return setGroupAndRequest(flag, type, true, "", async)
    }

    /**
     * 拒绝加群请求／邀请
     * @param flag 加好友请求的 flag（需从上报的数据中获得）
     * @param type add 或 invite，请求类型（需要和上报消息中的 sub_type 字段相符）
     * @param reason 拒绝理由
     */
    fun rejectGroupRequest(flag: String, type: String, reason: String, async: Boolean = false): UnitResp {
        return setGroupAndRequest(flag, type, false, reason, async)
    }

    /**
     * 重启酷 Q，并以当前登录号自动登录（需勾选快速登录）
     * @param cleanCache 是否清除酷Q当前登录号缓存数据
     */
    fun setRestart(cleanCache: Boolean = false, async: Boolean = false): UnitResp {
        return sendRequest(SET_RESTART, async, "clean_cache", cleanCache).toUnitResp()
    }

    /**
     * 重启 HTTP API 插件
     */
    fun setRestartPlugin(async: Boolean = false): UnitResp {
        return sendRequest(SET_RESTART_PLUGIN, async).toUnitResp()
    }


    /**
     * 获取登录号信息
     */
    fun getLoginInfo(): LoginInfoResp {
        return sendRequest(GET_LOGIN_INFO, false).toLoginInfoResp()
    }

    /**
     * 获取陌生人信息
     * @param qq QQ号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     */
    fun getStrangerInfo(qq: Long, noCache: Boolean = false): UserInfoResp {
        return sendRequest(GET_STRANGER_INFO, false, "user_id", qq, "no_cache", noCache).toUserInfoResp()
    }

    /**
     * 获取群列表
     */
    fun getGroupList(): ReturnListData<RGroup> {
        return sendReturnList(RGroup::class.java, GET_GROUP_LIST)
    }

    /**
     * 获取群成员信息
     * @param groupId 群号
     * @param qq QQ 号（不可以是登录号）
     */
    fun getGroupMemberInfo(groupId: Long, qq: Long): DataResp<GroupUserInfo> {
        return send(RGroupMemberInfo::class.java, GET_GROUP_MEMBER_INFO, "group_id", groupId, "user_id", qq)
    }

    /**
     * 获取群信息
     * @param groupId 群号
     */
    fun getGroupInfo(groupId: Long): GroupInfo.Resp {
        return GroupInfo.Resp(sendRequest(GET_GROUP_INFO, false, "group_id", groupId))
    }

    /**
     * 获取群成员列表
     * @param groupId 群号
     */
    fun getGroupMemberList(groupId: Long): ReturnListData<RGroupMemberInfo> {
        return sendReturnList(RGroupMemberInfo::class.java, GET_GROUP_MEMBER_LIST, "group_id", groupId)
    }

    /**
     * (实验性) 获取好友列表
     */
    fun getFriendList(): ReturnListData<RFriendList> {
        return sendReturnList(RFriendList::class.java, GET_FRIEND_LIST)
    }

    /**
     * 获取酷 Q 及 HTTP API 插件的版本信息
     */
    fun getVersionInfo(): ReturnData<RVersionInfo> {
        return send(RVersionInfo::class.java, GET_VERSION_INFO)
    }

    /**
     * 获取插件运行状态
     */
    fun getStatus(): ReturnData<RStatus> {
        return send(RStatus::class.java, GET_STATUS)
    }

    /**
     * 清空数据文件夹
     */
    fun cleanDataDir(async: Boolean = false): UnitResp {
        return sendRequest(CLEAN_DATA_DIR, async).toUnitResp()
    }

    /**
     * 清空插件日志
     */
    fun cleanPluginLog(async: Boolean = false): UnitResp {
        return sendRequest(CLEAN_PLUGIN_LOG, async).toUnitResp()
    }

    protected fun 资源.toUnitResp(): UnitResp {
        return UnitResp(this)
    }

    protected fun 资源.toMsgResp(): LocalMsg {
        return LocalMsg(this, this@TinyApi)
    }

    protected fun 资源.toLoginInfoResp(): LoginInfoResp {
        return LoginInfoResp(this)
    }

    protected fun 资源.toUserInfoResp(): UserInfoResp {
        return UserInfoResp(this)
    }

    private fun formatParams(vararg params: Any): Map<String, Any> {
        if (params.size % 2 != 0) throw IllegalArgumentException("参数数量错误")
        var iskey = true
        var key: String? = null
        val ret = HashMap<String, Any>()
        for (v in params) {
            if (iskey) {
                if (v is String) {
                    key = v;
                } else {
                    throw IllegalArgumentException("键值不是字符串")
                }
                iskey = false
            } else {
                ret.put(key, v)
            }
        }
    }


}