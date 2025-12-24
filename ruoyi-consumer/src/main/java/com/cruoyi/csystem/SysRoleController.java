package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.entity.SysRole;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.feign.SysRoleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色管理Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleClient sysRoleClient;

    @GetMapping("/list")
    public TableDataInfo list(SysRole role) {
        role.setParams(null);
        return sysRoleClient.list(role);
    }

    @GetMapping("/{roleId}")
    public AjaxResult getInfo(@PathVariable Long roleId) {
        return sysRoleClient.getInfo(roleId);
    }

    @PostMapping
    public AjaxResult add(@RequestBody SysRole role) {
        return sysRoleClient.add(role);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody SysRole role) {
        return sysRoleClient.edit(role);
    }

    @DeleteMapping("/{roleIds}")
    public AjaxResult remove(@PathVariable Long[] roleIds) {
        return sysRoleClient.remove(roleIds);
    }

    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysRole role) {
        return sysRoleClient.changeStatus(role);
    }

    @GetMapping("/optionselect")
    public AjaxResult optionselect() {
        return sysRoleClient.optionselect();
    }

    @GetMapping("/deptTree/{roleId}")
    public AjaxResult deptTree(@PathVariable Long roleId) {
        return sysRoleClient.deptTree(roleId);
    }
}
