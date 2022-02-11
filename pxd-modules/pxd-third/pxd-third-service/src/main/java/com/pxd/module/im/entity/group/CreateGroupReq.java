package com.pxd.module.im.entity.group;


import com.pxd.module.im.enums.GroupTypeEnum;

public class CreateGroupReq {


    /*** 群主 ID（需是 已导入 的账号）。填写后自动添加到群成员中；如果不填，群没有群主 */
    private String Owner_Account;

    /*** 群组形态，包括 Public（陌生人社交群），Private（即 Work，好友工作群），ChatRoom（即 Meeting，会议群），AVChatRoom（直播群）*/
    private String Type;

    /*** 为了使得群组 ID 更加简单，便于记忆传播，腾讯云支持 App 在通过 REST API 创建群组时 自定义群组 ID */
    private String GroupId;

    /*** 群名称，最长30字节，使用 UTF-8 编码，1个汉字占3个字节 */
    private String Name;

    public String getOwner_Account() {
        return Owner_Account;
    }

    public void setOwner_Account(String owner_Account) {
        Owner_Account = owner_Account;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static CreateGroupReq init(String ownerAccount, GroupTypeEnum groupTypeEnum, String name) {
        CreateGroupReq createGroupReq = new CreateGroupReq();
        createGroupReq.setOwner_Account(ownerAccount);
        createGroupReq.setType(groupTypeEnum.toString());
        createGroupReq.setName(name);
        return createGroupReq;
    }

    public static CreateGroupReq init(String ownerAccount, GroupTypeEnum groupTypeEnum, String name, String groupId) {
        CreateGroupReq createGroupReq = init(ownerAccount, groupTypeEnum, name);
        createGroupReq.setGroupId(groupId);
        return createGroupReq;
    }

}
