package com.cruoyi.csystem;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.feign.TeacherNotifyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher/notify")
public class TeacherNotifyController {
    @Autowired
    private TeacherNotifyClient teacherNotifyClient;
    @GetMapping("/list")
    public AjaxResult getNotifyList(@RequestParam(required = false) Integer readStatus){
        return teacherNotifyClient.getNotifyList(readStatus);
    }

    // 2. 获取正考/补考开关状态
    @GetMapping("/exam/status")
    public AjaxResult getExamStatus(){
        return teacherNotifyClient.getExamStatus();
    }

    // 3. 标记全部已读
    @PutMapping("/read/all")
    public AjaxResult markAllRead(){
        return teacherNotifyClient.markAllRead();
    }
    // 4. 标记单条已读
    @PutMapping("/read/{notifyId}")
    public AjaxResult markSingleRead(@PathVariable Long notifyId){
        return teacherNotifyClient.markSingleRead(notifyId);
    }

    // 5. 获取未读数量
    @GetMapping("/unread/count")
    public AjaxResult getUnreadCount(){
        return teacherNotifyClient.getUnreadCount();
    }
}
