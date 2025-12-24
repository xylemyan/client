package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.entity.SysMenu;
import com.cruoyi.feign.SysMenuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单管理Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuClient sysMenuClient;

    @GetMapping("/list")
    public AjaxResult list(SysMenu menu) {
        menu.setParams(null);
        return sysMenuClient.list(menu);
    }

    @GetMapping("/{menuId}")
    public AjaxResult getInfo(@PathVariable Long menuId) {
        return sysMenuClient.getInfo(menuId);
    }

    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysMenu menu) {
        menu.setParams(null);
        return sysMenuClient.treeselect(menu);
    }

    @GetMapping("/roleMenuTreeselect/{roleId}")
    public AjaxResult roleMenuTreeselect(@PathVariable("roleId") Long roleId) {
        return sysMenuClient.roleMenuTreeselect(roleId);
    }

    @PostMapping
    public AjaxResult add(@RequestBody SysMenu menu) {
        return sysMenuClient.add(menu);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody SysMenu menu) {
        return sysMenuClient.edit(menu);
    }

    @DeleteMapping("/{menuId}")
    public AjaxResult remove(@PathVariable Long menuId) {
        return sysMenuClient.remove(menuId);
    }
}
