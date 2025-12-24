package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.entity.SysMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单管理Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "sysMenuClient")
public interface SysMenuClient {

    @GetMapping("/system/menu/list")
    AjaxResult list(@SpringQueryMap SysMenu menu);

    @GetMapping("/system/menu/{menuId}")
    AjaxResult getInfo(@PathVariable("menuId") Long menuId);

    @GetMapping("/system/menu/treeselect")
    AjaxResult treeselect(@SpringQueryMap SysMenu menu);

    @GetMapping("/system/menu/roleMenuTreeselect/{roleId}")
    AjaxResult roleMenuTreeselect(@PathVariable("roleId") Long roleId);

    @PostMapping("/system/menu")
    AjaxResult add(@RequestBody SysMenu menu);

    @PutMapping("/system/menu")
    AjaxResult edit(@RequestBody SysMenu menu);

    @DeleteMapping("/system/menu/{menuId}")
    AjaxResult remove(@PathVariable("menuId") Long menuId);
}
