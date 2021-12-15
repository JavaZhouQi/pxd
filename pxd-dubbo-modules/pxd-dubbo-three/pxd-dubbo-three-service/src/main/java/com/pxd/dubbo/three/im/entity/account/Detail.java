package com.pxd.dubbo.three.im.entity.account;

public class Detail {

    /*** 登录的平台类型。可能的返回值有："iPhone", "Android", "Web", "PC", "iPad", "Mac"。*/
    private String Platform;

    /*** 该登录平台的状态 */
    private String Status;

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
