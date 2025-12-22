package com.cruoyi.csystem;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.feign.SystemNotifyMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher/notify")
public class SystemNotifyMessageController {
    @Autowired
    private SystemNotifyMessageClient systemNotifyMessageClient;
    @GetMapping("/list")
    public AjaxResult getNotifyList(@RequestParam(required = false) Integer readStatus){
        return systemNotifyMessageClient.getNotifyList(readStatus);
    }

    // 2. 获取正考/补考开关状态
    @GetMapping("/exam/status")
    public AjaxResult getExamStatus(){
        return systemNotifyMessageClient.getExamStatus();
    }

    // 3. 标记全部已读
    @PutMapping("/read/all")
    public AjaxResult markAllRead(){
        return systemNotifyMessageClient.markAllRead();
    }
    // 4. 标记单条已读
    @PutMapping("/read/{notifyId}")
    public AjaxResult markSingleRead(@PathVariable Long notifyId){
        return systemNotifyMessageClient.markSingleRead(notifyId);
    }

    // 5. 获取未读数量
    @GetMapping("/unread/count")
    public AjaxResult getUnreadCount(){
        return systemNotifyMessageClient.getUnreadCount();
    }
}
