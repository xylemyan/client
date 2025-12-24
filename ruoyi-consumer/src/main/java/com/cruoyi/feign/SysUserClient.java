package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.entity.SysDept;
import com.cruoyi.common.core.domain.entity.SysUser;
import com.cruoyi.common.core.page.TableDataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "sysUserClient")
public interface SysUserClient {

    @GetMapping("/system/user/list")
    TableDataInfo list(@SpringQueryMap SysUser user);

    @GetMapping(value = "/system/user/")
    AjaxResult getInfo();

    @GetMapping(value = "/system/user/{userId}")
    AjaxResult getInfo(@PathVariable("userId") Long userId);

    @PostMapping("/system/user")
    AjaxResult add(@RequestBody SysUser user);

    @PutMapping("/system/user")
    AjaxResult edit(@RequestBody SysUser user);

    @DeleteMapping("/system/user/{userIds}")
    AjaxResult remove(@PathVariable("userIds") Long[] userIds);

    @PutMapping("/system/user/resetPwd")
    AjaxResult resetPwd(@RequestBody SysUser user);

    @PutMapping("/system/user/changeStatus")
    AjaxResult changeStatus(@RequestBody SysUser user);

    @GetMapping("/system/user/authRole/{userId}")
    AjaxResult authRole(@PathVariable("userId") Long userId);

    @PutMapping("/system/user/authRole")
    AjaxResult insertAuthRole(@RequestParam("userId") Long userId, @RequestParam("roleIds") Long[] roleIds);

    @GetMapping("/system/user/deptTree")
    AjaxResult deptTree(@SpringQueryMap SysDept dept);
}
