package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.SysOperLog;
import com.cruoyi.feign.SysOperlogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 操作日志Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/monitor/operlog")
public class SysOperlogController extends BaseController {

    @Autowired
    private SysOperlogClient sysOperlogClient;

    @GetMapping("/list")
    public TableDataInfo list(SysOperLog operLog) {
        return sysOperlogClient.list(operLog);
    }

    @DeleteMapping("/{operIds}")
    public AjaxResult remove(@PathVariable Long[] operIds) {
        return sysOperlogClient.remove(operIds);
    }

    @DeleteMapping("/clean")
    public AjaxResult clean() {
        return sysOperlogClient.clean();
    }
}
