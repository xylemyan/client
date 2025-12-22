package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ruoyi-server", url = "http://localhost:8081", contextId = "systemNotifyMessageClient")
public interface SystemNotifyMessageClient {
    @GetMapping("/list")
    public AjaxResult getNotifyList(@RequestParam(required = false, value = "readStatus") Integer readStatus);

    // 2. 获取正考/补考开关状态
    @GetMapping("/exam/status")
    public AjaxResult getExamStatus();

    // 3. 标记全部已读
    @PutMapping("/read/all")
    public AjaxResult markAllRead();
    // 4. 标记单条已读
    @PutMapping("/read/{notifyId}")
    public AjaxResult markSingleRead(@PathVariable("notifyId") Long notifyId);

    // 5. 获取未读数量
    @GetMapping("/unread/count")
    public AjaxResult getUnreadCount();
}
