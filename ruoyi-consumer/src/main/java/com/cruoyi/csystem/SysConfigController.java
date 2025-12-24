package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.feign.SysConfigClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统配置Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/config")
public class SysConfigController extends BaseController {

    @Autowired
    private SysConfigClient sysConfigClient;

    @GetMapping("/configKey/{configKey}")
    public AjaxResult getConfigKey(@PathVariable String configKey) {
        return sysConfigClient.getConfigKey(configKey);
    }

    @GetMapping("/{configId}")
    public AjaxResult getInfo(@PathVariable Long configId) {
        return sysConfigClient.getInfo(configId);
    }
}
