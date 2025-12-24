package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.feign.SysNoticeClient;
import com.cruoyi.domain.SysNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通知公告Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/notice")
public class SysNoticeController extends BaseController {

    @Autowired
    private SysNoticeClient sysNoticeClient;

    @GetMapping("/list")
    public TableDataInfo list(SysNotice notice) {
        return sysNoticeClient.list(notice);
    }

    @GetMapping("/{noticeId}")
    public AjaxResult getInfo(@PathVariable Long noticeId) {
        return sysNoticeClient.getInfo(noticeId);
    }

    @PostMapping
    public AjaxResult add(@RequestBody SysNotice notice) {
        return sysNoticeClient.add(notice);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody SysNotice notice) {
        return sysNoticeClient.edit(notice);
    }

    @DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds) {
        return sysNoticeClient.remove(noticeIds);
    }
}
