package com.pxd.dubbo.three.im.entity.msg.context;

public class TIMLocationElem implements MsgContent{

    /*** 地理位置描述信息。*/
    private String Desc;
    /*** 纬度 */
    private Double Latitude;
    /*** 经度 */
    private Double Longitude;

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }
}
