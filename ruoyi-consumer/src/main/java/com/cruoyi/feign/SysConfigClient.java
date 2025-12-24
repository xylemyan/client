package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 系统配置Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "sysConfigClient")
public interface SysConfigClient {

    @GetMapping("/system/config/configKey/{configKey}")
    AjaxResult getConfigKey(@PathVariable("configKey") String configKey);

    @GetMapping("/system/config/{configId}")
    AjaxResult getInfo(@PathVariable("configId") Long configId);
}
