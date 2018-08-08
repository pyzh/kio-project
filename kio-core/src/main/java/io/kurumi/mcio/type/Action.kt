package io.kurumi.mcio.type

import cn.hutool.core.util.StrUtil
import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField.Companion.enumField
import io.kurumi.json.fields.StringField

/**
 * 触发的事件
 */
class Action : JSONObject() {

    /**
     * 所触发的行为。
     *
     * 点击 :
     *
     * 有效值为“open_url”
     * （在玩家的默认浏览器中打开value中的URL地址），
     * “run_command”（以玩家的身份在聊天框中输入value值并提交。
     *
     * 可以用来执行命令，但是如果玩家没有所需的权限，命令会失败），
     * “change_page”（只能用在成书中，如果该value页存在，翻至该页）
     * 和“suggest_command”（和“run_command”相似，
     * 但是文本只会出现在玩家的聊天输入栏，并不会自动提交。
     * 与insertion不同，这会直接取代原先在聊天输入框中的内容）。
     *
     * “open_file”和“twitch_user_info”
     * 用于游戏自动生成的信息中（如截图时显示的信息），
     * 不能在命令和告示牌中使用。
     *
     * 鼠标指针悬浮 :
     *
     * 有效值为“show_text”（显示JSON文本）、
     * “show_item”（显示一个可带NBT标签的物品）、
     * “show_achievement”（显示成就描述或统计数据。
     * 普通成就显示为绿色，
     * 终极成就显示为深紫色，
     * 统计数据名称显示为灰色。
     * 成就的显示会附加描述）
     * 和“show_entity”（
     * 显示实体的名称，还可能显示其类型和UUID）。
     */
    var action by enumField<Type>("action", Type.Companion::keyTrans)

    /**
     * 点击 :
     * 前述指定的action使用到的内容
     * (URL地址、聊天内容或命令。)
     * 注意，命令之前一定要加上“/”斜杠。
     *
     * 鼠标悬浮 :
     * “show_text”是唯一接受对象作为value值的action；
     *
     * 其它action对应的value值都是字符串，所以必须用引号包含。
     * "show_text"：可以是字符串，
     * 或是与基础对象格式相同的一个对象。
     * 注意，此对象的clickEvent和hoverEvent在说明提示中不会生效，
     * 但是它的格式和extra标签仍然有效。
     *
     * "show_item"：与物品NBT标签格式相同的的字符串。
     * 包含“id”标签，
     * 和可选的“Damage”标签和“tag”标签
     * （和/give命令所使用的“dataTag”标签中的组合相同）。
     *
     * "show_achievement"：成就或统计数据的名称。
     * 其格式与成就、统计数据记分板对象判据
     * 以及/achievement命令相同。
     *
     * "show_entity"：描述一个组合的字符串，
     * 包含字符串值“type”（例如“Zombie”）、
     * “name”和“id”（要求为实体UUID，但接受任意字符串）。
     */
    var value by StringField("value")

    val isInvalid get() = action == null || value == null

    enum class Type(val id: String) {

        OpenUrl("open_url"),
        RunCommand("run_command"),
        ChangePage("change_page"),
        Suggest_Command("suggest_command"),
        OpenFile("open_file"),
        TwitchUserInfo("twitch_user_info"),

        ShowText("show_text"),
        ShowTtem("show_item"),
        ShowEntity("show_entity");

        override fun toString(): String {
            return id
        }

        companion object {

            fun keyTrans(key: Any?): String {
                return StrUtil.upperFirst(StrUtil.toCamelCase(key?.toString() ?: ""))
            }

        }

    }

}