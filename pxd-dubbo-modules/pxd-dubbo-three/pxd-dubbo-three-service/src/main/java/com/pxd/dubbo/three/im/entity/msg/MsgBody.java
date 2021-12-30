package com.pxd.dubbo.three.im.entity.msg;

import com.pxd.dubbo.three.im.entity.msg.context.MsgContent;
import com.pxd.dubbo.three.im.entity.msg.context.TIMTextElem;
import com.pxd.dubbo.three.im.enums.MsgTypeEnum;

public class MsgBody {

    /*** TIM 消息对象类型，目前支持的消息对象包括：*/
    private String MsgType;

    /*** 对于每种 MsgType 用不同的 MsgContent 格式，具体可参考 消息格式描述 */
    private MsgContent MsgContent;

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public MsgContent getMsgContent() {
        return MsgContent;
    }

    public void setMsgContent(MsgContent msgContent) {
        MsgContent = msgContent;
    }

    /**
     * 创建文本消息
     *
     * @param text 消息内容
     * @return
     */
    public static MsgBody createText(String text) {
        MsgBody msgBody = new MsgBody();
        msgBody.setMsgType(MsgTypeEnum.TIMTextElem.toString());
        msgBody.setMsgContent(new TIMTextElem(text));
        return msgBody;
    }
}
