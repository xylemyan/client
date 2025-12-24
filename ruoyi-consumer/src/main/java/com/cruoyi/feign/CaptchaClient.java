package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.csystem.config.FeignHttpsConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "captchaClient",
        configuration = FeignHttpsConfig.class)
public interface CaptchaClient {
    @GetMapping("/captchaImage")
    public AjaxResult getCode();
}
