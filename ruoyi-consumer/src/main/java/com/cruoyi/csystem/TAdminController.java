package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.TAdmin;
import com.cruoyi.feign.AdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员信息Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/admin")
public class TAdminController extends BaseController {

    @Autowired
    private AdminClient adminClient;

    @GetMapping("/list")
    public TableDataInfo list(TAdmin tAdmin) {
        return adminClient.list(tAdmin);
    }

    @GetMapping("/{adminId}")
    public AjaxResult getInfo(@PathVariable("adminId") String adminId) {
        return adminClient.getInfo(adminId);
    }

    @PostMapping
    public AjaxResult add(@RequestBody TAdmin tAdmin) {
        return adminClient.add(tAdmin);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody TAdmin tAdmin) {
        return adminClient.edit(tAdmin);
    }

    @DeleteMapping("/{adminIds}")
    public AjaxResult remove(@PathVariable String[] adminIds) {
        return adminClient.remove(adminIds);
    }
}
