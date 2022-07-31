package com.zhao.controller;

import com.zhao.unit.ValidateCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author huang
 * @date 2022-7-31
 * @description 接口获取验证码
 */

@RestController
public class ValidateCodeController {
    // 生成验证码图片
    @RequestMapping("/getCaptchaImage")
    @ResponseBody
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");

            ValidateCode validateCode = new ValidateCode();
            // 直接返回图片
            validateCode.getRandomCodeImage(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

