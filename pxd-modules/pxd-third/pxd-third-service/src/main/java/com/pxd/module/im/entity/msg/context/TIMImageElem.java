package com.pxd.module.im.entity.msg.context;

import java.util.List;

public class TIMImageElem implements MsgContent {

    /*** 图片的唯一标识，客户端用于索引图片的键值。*/
    private String UUID;

    /*** 图片格式。JPG = 1，GIF = 2，PNG = 3，BMP = 4，其他 = 255。*/
    private Integer ImageFormat;

    /*** 原图、缩略图或者大图下载信息。*/
    private List<ImageInfo> Url;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Integer getImageFormat() {
        return ImageFormat;
    }

    public void setImageFormat(Integer imageFormat) {
        ImageFormat = imageFormat;
    }

    public List<ImageInfo> getUrl() {
        return Url;
    }

    public void setUrl(List<ImageInfo> url) {
        Url = url;
    }
}
