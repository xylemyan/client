package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "ruoyi-server", url = "http://localhost:8081", contextId = "systemNotifyMessageClient")
public interface TeacherNotifyClient {
    @GetMapping("/teacher/notify/list")
    public AjaxResult getNotifyList(@RequestParam(required = false, value = "readStatus") Integer readStatus);

    // 2. 获取正考/补考开关状态
    @GetMapping("/teacher/notify/exam/status")
    public AjaxResult getExamStatus();

    // 3. 标记全部已读
    @PutMapping("/teacher/notify/read/all")
    public AjaxResult markAllRead();
    // 4. 标记单条已读
    @PutMapping("/teacher/notify/read/{notifyId}")
    public AjaxResult markSingleRead(@PathVariable("notifyId") Long notifyId);

    // 5. 获取未读数量
    @GetMapping("/teacher/notify/unread/count")
    public AjaxResult getUnreadCount();
}
