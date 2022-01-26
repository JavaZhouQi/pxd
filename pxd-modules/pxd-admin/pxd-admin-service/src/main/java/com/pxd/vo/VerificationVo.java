package com.pxd.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VerificationVo {

    @ApiModelProperty(value = "验证码图片（Base64格式）")
    private String image;

    @ApiModelProperty(value = "验证码id")
    private String codeId;

    public static VerificationVo init(String image, String codeId) {
        VerificationVo verificationVo = new VerificationVo();
        verificationVo.setImage(image);
        verificationVo.setCodeId(codeId);
        return verificationVo;
    }
}
