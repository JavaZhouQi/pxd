package com.pxd.dubbo.three.im.entity;

import java.util.Objects;

public class ImResp {

    private static final int SUCCESS_CODE = 0;

    /*** 请求处理的结果，OK 表示处理成功，FAIL 表示失败 */
    private String ActionStatus;

    /*** 错误码，0表示成功，非0表示失败 */
    private Integer ErrorCode;

    /*** 错误信息 */
    private String ErrorInfo;

    public String getActionStatus() {
        return ActionStatus;
    }

    public void setActionStatus(String actionStatus) {
        ActionStatus = actionStatus;
    }

    public Integer getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(Integer errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorInfo() {
        return ErrorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        ErrorInfo = errorInfo;
    }

    public static boolean isOk(ImResp imResp) {
        return Objects.equals(imResp.getErrorCode(), SUCCESS_CODE);
    }
}
