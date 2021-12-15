package com.pxd.dubbo.three.im.entity.msg;

public class AdminGetroammsgReq {

    /*** 会话其中一方的 UserID，若已指定发送消息方帐号，则为消息发送方*/
    private String From_Account;
    /*** 会话其中一方的 UserID */
    private String To_Account;
    /*** 请求的消息条数 */
    private Integer MaxCnt;
    /*** 请求的消息时间范围的最小值 */
    private Long MinTime;
    /*** 请求的消息时间范围的最大值 */
    private Long MaxTime;
    /*** 上一次拉取到的最后一条消息的 MsgKey，续拉时需要填该字段 */
    private String LastMsgKey;

    public String getFrom_Account() {
        return From_Account;
    }

    public void setFrom_Account(String from_Account) {
        From_Account = from_Account;
    }

    public String getTo_Account() {
        return To_Account;
    }

    public void setTo_Account(String to_Account) {
        To_Account = to_Account;
    }

    public Integer getMaxCnt() {
        return MaxCnt;
    }

    public void setMaxCnt(Integer maxCnt) {
        MaxCnt = maxCnt;
    }

    public Long getMinTime() {
        return MinTime;
    }

    public void setMinTime(Long minTime) {
        MinTime = minTime;
    }

    public Long getMaxTime() {
        return MaxTime;
    }

    public void setMaxTime(Long maxTime) {
        MaxTime = maxTime;
    }

    public String getLastMsgKey() {
        return LastMsgKey;
    }

    public void setLastMsgKey(String lastMsgKey) {
        LastMsgKey = lastMsgKey;
    }
}
