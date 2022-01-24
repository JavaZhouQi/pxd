package com.pxd;

import cloud.tianai.captcha.template.slider.DefaultSliderCaptchaResourceManager;
import cloud.tianai.captcha.template.slider.DefaultSliderCaptchaTemplate;
import cloud.tianai.captcha.template.slider.SliderCaptchaInfo;
import cloud.tianai.captcha.template.slider.SliderCaptchaResourceManager;
import cn.hutool.json.JSONUtil;

public class Captcha {

    public static void main(String[] args) {
        SliderCaptchaResourceManager sliderCaptchaResourceManager = new DefaultSliderCaptchaResourceManager();
        DefaultSliderCaptchaTemplate sliderCaptchaTemplate = new DefaultSliderCaptchaTemplate(sliderCaptchaResourceManager, true);
        // 生成滑块图片
        SliderCaptchaInfo slideImageInfo = sliderCaptchaTemplate.getSlideImageInfo();
        // 获取背景图片的base64
        String backgroundImage = slideImageInfo.getBackgroundImage();
        // 获取滑块图片
        String sliderImage = slideImageInfo.getSliderImage();
        // 获取滑块被背景图片的百分比， (校验图片使用)
        Float xPercent = slideImageInfo.getXPercent();

        System.out.println(JSONUtil.toJsonStr(slideImageInfo));
    }
}
