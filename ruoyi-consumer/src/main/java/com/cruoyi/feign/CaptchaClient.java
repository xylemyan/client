package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
@FeignClient(name = "ruoyi-server", url = "http://localhost:8081", contextId = "captchaClient")
public interface CaptchaClient {
    @GetMapping("/captchaImage")
    public AjaxResult getCode();
}
