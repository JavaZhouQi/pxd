package com.pxd.module.im.entity.account;

public class AccountImportReq {

    /*** 用户名，长度不超过32字节 */
    private String Identifier;

    /*** 用户昵称 */
    private String Nick;

    /*** 用户头像 URL */
    private String FaceUrl;

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String nick) {
        Nick = nick;
    }

    public String getFaceUrl() {
        return FaceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        FaceUrl = faceUrl;
    }

    /**
     * 导入单个帐号
     *
     * @param userId  用户ID
     * @param nick    用户名称
     * @param faceUrl 用户头像地址
     * @return 导入单个帐号对象
     */
    public static AccountImportReq init(String userId, String nick, String faceUrl) {
        AccountImportReq accountImportReq = new AccountImportReq();
        accountImportReq.setIdentifier(userId);
        accountImportReq.setNick(nick);
        accountImportReq.setFaceUrl(faceUrl);
        return accountImportReq;
    }
}
