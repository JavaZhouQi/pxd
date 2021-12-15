package com.pxd.dubbo.three.im.entity.account;

import java.util.List;


public class QueryResult {

    /*** 返回的用户的 UserID */
    private String To_Account;

    /***
     * 返回的用户状态，目前支持的状态有：
     * 前台运行状态（Online）：客户端登录后和即时通信 IM 后台有长连接
     * 后台运行状态（PushOnline）：iOS 和 Android 进程被 kill 或因网络问题掉线，进入 PushOnline 状态，此时仍然可以接收消息的离线推送。客户端切到后台，但是进程未被手机操作系统 kill 掉时，此时状态仍是 Online
     * 未登录状态（Offline）：客户端主动退出登录或者客户端自上一次登录起7天之内未登录过
     * 如果用户是多终端登录，则只要有一个终端的状态是 Online ，该字段值就是 Online
     */
    private String Status;

    /*** 详细的登录平台信息 */
    private List<Detail> Detail;

    /*** 状态查询失败的帐号列表，在此列表中的目标帐号，状态查询失败或目标帐号不存在。若状态全部查询成功，则 ErrorList 为空 */
    private List<ErrorList> ErrorList;

    public String getTo_Account() {
        return To_Account;
    }

    public void setTo_Account(String to_Account) {
        To_Account = to_Account;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<Detail> getDetail() {
        return Detail;
    }

    public void setDetail(List<Detail> detail) {
        Detail = detail;
    }

    public List<ErrorList> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<ErrorList> errorList) {
        ErrorList = errorList;
    }
}
