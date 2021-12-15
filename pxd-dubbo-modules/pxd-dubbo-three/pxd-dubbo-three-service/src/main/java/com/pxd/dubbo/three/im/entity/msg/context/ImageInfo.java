package com.pxd.dubbo.three.im.entity.msg.context;

public class ImageInfo {

    /*** 图片类型： 1-原图，2-大图，3-缩略图。*/
    private Integer Type;

    /*** 图片数据大小，单位：字节。*/
    private Long Size;

    /*** 图片宽度，单位为像素。*/
    private Integer Width;

    /*** 图片高度，单位为像素。*/
    private Integer Height;

    /*** 图片下载地址。*/
    private String URL;

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public Long getSize() {
        return Size;
    }

    public void setSize(Long size) {
        Size = size;
    }

    public Integer getWidth() {
        return Width;
    }

    public void setWidth(Integer width) {
        Width = width;
    }

    public Integer getHeight() {
        return Height;
    }

    public void setHeight(Integer height) {
        Height = height;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
