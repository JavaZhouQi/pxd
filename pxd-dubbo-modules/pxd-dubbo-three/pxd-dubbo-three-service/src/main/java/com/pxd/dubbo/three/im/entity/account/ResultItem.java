package com.pxd.dubbo.three.im.entity.account;

public class ResultItem {

    /*** 单个帐号的错误码，0表示成功，非0表示失败 */
    private Integer ResultCode;

    /*** 单个帐号删除失败时的错误描述信息 */
    private String ResultInfo;

    /*** 请求删除的帐号的 UserID */
    private String UserID;

    public Integer getResultCode() {
        return ResultCode;
    }

    public void setResultCode(Integer resultCode) {
        ResultCode = resultCode;
    }

    public String getResultInfo() {
        return ResultInfo;
    }

    public void setResultInfo(String resultInfo) {
        ResultInfo = resultInfo;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
