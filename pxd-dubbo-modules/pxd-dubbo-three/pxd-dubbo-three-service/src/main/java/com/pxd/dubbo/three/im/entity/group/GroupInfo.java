package com.pxd.dubbo.three.im.entity.group;

import com.pxd.dubbo.three.im.entity.ImKeyValueDTO;
import com.pxd.dubbo.three.im.entity.ImResp;

import java.util.List;

public class GroupInfo extends ImResp {

    /*** 群组 ID，App 内保证唯一，其格式前缀为 @TGS#。另外，App 亦可自定义群组 ID */
    private String GroupId;
    /*** 只读
     默认支持以下群组类型：好友工作群（Work）、陌生人社交群（Public）、临时会议群（Meeting）、直播群（AVChatRoom）、社群（Community），详情请参阅 群组类型介绍
     旧版本 SDK 中还包含 Private、ChatRoom 以及 BChatRoom 类型，不建议使用 */
    private String Type;
    /*** 可读可写。最长30字节，不可调整 */
    private String Name;
    /*** 可读可写。最长240字节，不可调整 */
    private String Introduction;
    /*** 可读可写。最长300字节，不可调整 */
    private String Notification;
    /*** 群组维度的自定义字段 */
    private List<ImKeyValueDTO> AppDefinedData;
    /*** 群成员列表 */
    private List<MemberListDTO> MemberList;

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getNotification() {
        return Notification;
    }

    public void setNotification(String notification) {
        Notification = notification;
    }

    public List<ImKeyValueDTO> getAppDefinedData() {
        return AppDefinedData;
    }

    public void setAppDefinedData(List<ImKeyValueDTO> appDefinedData) {
        AppDefinedData = appDefinedData;
    }

    public List<MemberListDTO> getMemberList() {
        return MemberList;
    }

    public void setMemberList(List<MemberListDTO> memberList) {
        MemberList = memberList;
    }
}
