package io.kurumi.mcio.type

import cn.hutool.json.JSONArray
import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField.Companion.enumField
import io.kurumi.json.JSONField.Companion.listField
import io.kurumi.json.JSONField.Companion.mapField
import io.kurumi.json.fields.BooleanField
import io.kurumi.json.fields.MapField
import io.kurumi.json.fields.StringField

/**
 * MC 使用的JSON文本
 */
class Label() : JSONObject() {

    /**
     * 一个包含了一个选择器的字符串以及可选的选择器参数 :
     * 不像text，此处的选择器将会被解析为正确的玩家/实体名。
     *
     * 如果多于一个玩家/实体符合条件，
     * 其将会被以例如'名字1和名字2'或'名字1,名字2,名字3,和名字4'的形式显示。
     *
     * 此参数存在时完全忽略t
     * text、translate和score。
     *
     * 在/tellraw命令中使用此标签时，
     * 点击结果中的玩家名称会出现私信该玩家的命令建议；
     * 按住⇧ Shift点击玩家名称会将名称填入聊天框中；
     * 按住⇧ Shift点击非玩家实体的名称会将其UUID填入聊天框中。
     */
    var selector by StringField("selector")

    /**
     * 字符串，存储在聊天框中直接出现的纯文字。
     * 目标选择器并不会转译成玩家名字；
     *
     * 必须使用selector代替。使用转义字符“\n”换行（回车）。
     *
     * @see selector
     */
    var text by StringField("name")

    fun text(text: String) {
        this.text = text;
    }

    /**
     * 渲染文字时使用的颜色。
     * @see Color
     */
    var color by enumField<Color>("color")

    /**
     * 是否将文字渲染为粗体
     */
    var bold by BooleanField("bold");

    /**
     * 是否为文字添加下划线
     */
    var underlined by BooleanField("underlined")

    /**
     * 是否将文字渲染为斜体
     */
    var italic by BooleanField("italic")

    /**
     * 是否将文字模糊处理
     */
    var obfuscated by BooleanField("obfuscated")

    /**
     * 当玩家点击文字时产生的事件。
     * @see Action
     */
    var clickEvent by mapField<Action>("clickEvent")

    /**
     * 当玩家将鼠标指针悬浮在文字之上时显示的说明提示。
     * @see Action
     */
    var hoverEvent by MapField("hoverEvent", Action::class.java)

    /**
     * 显示文本的翻译标识符，用于将文本翻译至玩家使用的语言。
     * 此标识符与assets文件夹或资源包中的标识符一致。
     * 翻译文本只会在text字符串未被使用时显示。
     */
    var translate by StringField("translate")

    /**
     * translate所使用的聊天对象参数列表和/或字符串参数。
     * 该参数为当前语言翻译文本中出现的参数赋值，
     * 参数依序排列（例如，列表中的第一个元素将会取代翻译文本中的“%1$s”）。
     * @see translate
     */
    var with by StringField("with")

    /**
     * 附加对象的列表，格式与基础对象相同。
     *
     * 与基础对象格式相同的附加对象（递归的）。
     * 注意所有对象的属性都会被其子对象所继承，
     * 除了text、extra、translate、with和score。
     *
     * 这表意味着子对象会保留与父对象相同的格式和事件，除非子对象明确声明将其覆盖。
     */
    var extra by listField<JSONArray>("extra")


}