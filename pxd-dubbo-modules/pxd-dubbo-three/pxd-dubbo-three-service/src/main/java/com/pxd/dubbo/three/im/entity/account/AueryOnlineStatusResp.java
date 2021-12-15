package com.pxd.dubbo.three.im.entity.account;

import com.pxd.dubbo.three.im.entity.ImResp;

import java.util.List;

public class AueryOnlineStatusResp extends ImResp {

    /*** 返回的用户在线状态结构化信息 */
    private List<QueryResult> QueryResult;

    /*** 状态查询失败的帐号列表，在此列表中的目标帐号，状态查询失败或目标帐号不存在。若状态全部查询成功，则 ErrorList 为空 */
    private List<ErrorList> ErrorList;

    public List<QueryResult> getQueryResult() {
        return QueryResult;
    }

    public void setQueryResult(List<QueryResult> queryResult) {
        QueryResult = queryResult;
    }

    public List<ErrorList> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<ErrorList> errorList) {
        ErrorList = errorList;
    }
}
