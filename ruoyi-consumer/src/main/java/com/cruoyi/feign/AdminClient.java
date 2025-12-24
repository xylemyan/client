package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.TAdmin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员信息Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "adminClient")
public interface AdminClient {

    @GetMapping("/system/admin/list")
    TableDataInfo list(@SpringQueryMap TAdmin tAdmin);

    @GetMapping("/system/admin/{adminId}")
    AjaxResult getInfo(@PathVariable("adminId") String adminId);

    @PostMapping("/system/admin")
    AjaxResult add(@RequestBody TAdmin tAdmin);

    @PutMapping("/system/admin")
    AjaxResult edit(@RequestBody TAdmin tAdmin);

    @DeleteMapping("/system/admin/{adminIds}")
    AjaxResult remove(@PathVariable("adminIds") String[] adminIds);
}
