package com.pxd.module.im.entity.msg.context;

public class TIMFaceElem implements MsgContent {

    /*** 表情索引，用户自定义。 */
    private Integer Number;

    /*** 额外数据。 */
    private String Data;

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
