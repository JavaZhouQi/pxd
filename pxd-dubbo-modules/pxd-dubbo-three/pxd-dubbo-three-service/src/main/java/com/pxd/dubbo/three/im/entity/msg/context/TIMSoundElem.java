package com.pxd.dubbo.three.im.entity.msg.context;

public class TIMSoundElem implements MsgContent {

    /*** 语音下载地址，可通过该 URL 地址直接下载相应语音。*/
    private String Url;

    /*** 语音的唯一标识，客户端用于索引语音的键值。*/
    private String UUID;

    /*** 语音数据大小，单位：字节。*/
    private Long Size;

    /*** 语音时长，单位：秒。*/
    private Long Second;

    /*** 语音下载方式标记。目前 Download_Flag 取值只能为2，表示可通过Url字段值的 URL 地址直接下载语音。*/
    private Integer Download_Flag = 2;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Long getSize() {
        return Size;
    }

    public void setSize(Long size) {
        Size = size;
    }

    public Long getSecond() {
        return Second;
    }

    public void setSecond(Long second) {
        Second = second;
    }

    public Integer getDownload_Flag() {
        return Download_Flag;
    }

    public void setDownload_Flag(Integer download_Flag) {
        Download_Flag = download_Flag;
    }
}
