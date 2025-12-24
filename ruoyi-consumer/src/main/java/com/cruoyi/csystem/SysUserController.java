package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.entity.SysDept;
import com.cruoyi.common.core.domain.entity.SysUser;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.feign.SysUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserClient sysUserClient;

    @GetMapping("/list")
    public TableDataInfo list(SysUser user) {
        user.setParams(null);
        return sysUserClient.list(user);
    }

    @GetMapping(value = "/")
    public AjaxResult getInfo() {
        return sysUserClient.getInfo();
    }

    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId) {
        return sysUserClient.getInfo(userId);
    }

    @PostMapping
    public AjaxResult add(@RequestBody SysUser user) {
        return sysUserClient.add(user);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody SysUser user) {
        return sysUserClient.edit(user);
    }

    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        return sysUserClient.remove(userIds);
    }

    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody SysUser user) {
        return sysUserClient.resetPwd(user);
    }

    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysUser user) {
        return sysUserClient.changeStatus(user);
    }

    @GetMapping("/authRole/{userId}")
    public AjaxResult authRole(@PathVariable("userId") Long userId) {
        return sysUserClient.authRole(userId);
    }

    @PutMapping("/authRole")
    public AjaxResult insertAuthRole(Long userId, Long[] roleIds) {
        return sysUserClient.insertAuthRole(userId, roleIds);
    }

    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept) {
        dept.setParams(null);
        return sysUserClient.deptTree(dept);
    }
}
