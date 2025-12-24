package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.SysOperLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 操作日志Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "sysOperlogClient")
public interface SysOperlogClient {

    @GetMapping("/monitor/operlog/list")
    TableDataInfo list(@SpringQueryMap SysOperLog operLog);

    @DeleteMapping("/monitor/operlog/{operIds}")
    AjaxResult remove(@PathVariable("operIds") Long[] operIds);

    @DeleteMapping("/monitor/operlog/clean")
    AjaxResult clean();
}
