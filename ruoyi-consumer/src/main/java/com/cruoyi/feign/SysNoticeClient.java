package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.SysNotice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 通知公告Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "sysNoticeClient")
public interface SysNoticeClient {

    @GetMapping("/system/notice/list")
    TableDataInfo list(@SpringQueryMap SysNotice notice);

    @GetMapping("/system/notice/{noticeId}")
    AjaxResult getInfo(@PathVariable("noticeId") Long noticeId);

    @PostMapping("/system/notice")
    AjaxResult add(@RequestBody SysNotice notice);

    @PutMapping("/system/notice")
    AjaxResult edit(@RequestBody SysNotice notice);

    @DeleteMapping("/system/notice/{noticeIds}")
    AjaxResult remove(@PathVariable("noticeIds") Long[] noticeIds);
}
