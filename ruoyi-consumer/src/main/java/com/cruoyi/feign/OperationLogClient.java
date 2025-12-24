package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.TOperationLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 操作日志Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "operationLogClient")
public interface OperationLogClient {

    @GetMapping("/system/operlog/list")
    TableDataInfo list(@SpringQueryMap TOperationLog operationLog);

    @GetMapping("/system/operlog/{logId}")
    AjaxResult getInfo(@PathVariable("logId") Long logId);
}
