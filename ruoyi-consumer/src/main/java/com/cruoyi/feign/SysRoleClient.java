package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.entity.SysRole;
import com.cruoyi.common.core.page.TableDataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 角色管理Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "sysRoleClient")
public interface SysRoleClient {

    @GetMapping("/system/role/list")
    TableDataInfo list(@SpringQueryMap SysRole role);

    @GetMapping("/system/role/{roleId}")
    AjaxResult getInfo(@PathVariable("roleId") Long roleId);

    @PostMapping("/system/role")
    AjaxResult add(@RequestBody SysRole role);

    @PutMapping("/system/role")
    AjaxResult edit(@RequestBody SysRole role);

    @DeleteMapping("/system/role/{roleIds}")
    AjaxResult remove(@PathVariable("roleIds") Long[] roleIds);

    @PutMapping("/system/role/changeStatus")
    AjaxResult changeStatus(@RequestBody SysRole role);

    @GetMapping("/system/role/optionselect")
    AjaxResult optionselect();

    @GetMapping("/system/role/deptTree/{roleId}")
    AjaxResult deptTree(@PathVariable("roleId") Long roleId);
}
