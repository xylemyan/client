package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.SysLogininfor;
import com.cruoyi.feign.SysLogininforClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录日志Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/monitor/logininfor")
public class SysLogininforController extends BaseController {

    @Autowired
    private SysLogininforClient sysLogininforClient;

    @GetMapping("/list")
    public TableDataInfo list(SysLogininfor logininfor) {
        return sysLogininforClient.list(logininfor);
    }

    @DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable Long[] infoIds) {
        return sysLogininforClient.remove(infoIds);
    }

    @DeleteMapping("/clean")
    public AjaxResult clean() {
        return sysLogininforClient.clean();
    }

    @GetMapping("/unlock/{userName}")
    public AjaxResult unlock(@PathVariable String userName) {
        return sysLogininforClient.unlock(userName);
    }
}
