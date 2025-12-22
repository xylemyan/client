package com.cruoyi.csystem;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.feign.CaptchaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class CaptchaController {
    @Autowired
    private CaptchaClient captchaClient;


    @GetMapping("/captchaImage")
    public AjaxResult getCode(){
        return captchaClient.getCode();
    }

}
