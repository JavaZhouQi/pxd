package com.pxd.module.im.entity.group;

import com.pxd.dubbo.three.im.entity.ImKeyValueDTO;

import java.util.List;

public class MemberListDTO {

    /*** 成员 ID */
    private String Member_Account;

    /*** 群内角色 */
    private String Role;

    /*** 群成员自定义字段 */
    private List<ImKeyValueDTO> AppMemberDefinedData;

    public String getMember_Account() {
        return Member_Account;
    }

    public void setMember_Account(String member_Account) {
        Member_Account = member_Account;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public List<ImKeyValueDTO> getAppMemberDefinedData() {
        return AppMemberDefinedData;
    }

    public void setAppMemberDefinedData(List<ImKeyValueDTO> appMemberDefinedData) {
        AppMemberDefinedData = appMemberDefinedData;
    }
}
