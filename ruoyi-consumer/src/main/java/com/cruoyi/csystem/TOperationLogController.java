package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.TOperationLog;
import com.cruoyi.feign.OperationLogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作日志Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/operlog")
public class TOperationLogController extends BaseController {

    @Autowired
    private OperationLogClient operationLogClient;

    @GetMapping("/list")
    public TableDataInfo list(TOperationLog operationLog) {
        return operationLogClient.list(operationLog);
    }

    @GetMapping("/{logId}")
    public AjaxResult getInfo(@PathVariable Long logId) {
        return operationLogClient.getInfo(logId);
    }
}
