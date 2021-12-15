package com.pxd.dubbo.three.im.entity.msg.context;

public class TIMTextElem implements MsgContent {

    /*** 消息内容。当接收方为 iOS 或 Android 后台在线时，作为离线推送的文本展示。 */
    private String Text;

    public TIMTextElem() {
    }

    public TIMTextElem(String text) {
        Text = text;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

}
