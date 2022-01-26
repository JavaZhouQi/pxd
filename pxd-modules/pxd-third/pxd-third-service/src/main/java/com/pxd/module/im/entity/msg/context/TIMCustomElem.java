package com.pxd.module.im.entity.msg.context;

public class TIMCustomElem implements MsgContent {

    /*** 自定义消息数据。 */
    private String Data;

    /*** 自定义消息描述信息。 */
    private String Desc;

    /*** 扩展字段。 */
    private String Ext;

    /*** 自定义 APNs 推送铃音。 */
    private String Sound;

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getExt() {
        return Ext;
    }

    public void setExt(String ext) {
        Ext = ext;
    }

    public String getSound() {
        return Sound;
    }

    public void setSound(String sound) {
        Sound = sound;
    }
}
