package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.SysLogininfor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 登录日志Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "sysLogininforClient")
public interface SysLogininforClient {

    @GetMapping("/monitor/logininfor/list")
    TableDataInfo list(@SpringQueryMap SysLogininfor logininfor);

    @DeleteMapping("/monitor/logininfor/{infoIds}")
    AjaxResult remove(@PathVariable("infoIds") Long[] infoIds);

    @DeleteMapping("/monitor/logininfor/clean")
    AjaxResult clean();

    @GetMapping("/monitor/logininfor/unlock/{userName}")
    AjaxResult unlock(@PathVariable("userName") String userName);
}
