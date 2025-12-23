package com.cruoyi.csystem;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.feign.StudentNotifyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student.notification/notification")
public class StudentNotifyController {
    @Autowired
    private StudentNotifyClient studentNotifyClient;
    //查询学生个人通知列表
    @GetMapping("/list")
    public TableDataInfo list(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) Long semester,
            @RequestParam(required = false) Long isRead
    ){
        return studentNotifyClient.list(academicYear,semester,isRead);
    }

    // 修改学生个人通知
    @PutMapping("")
    public AjaxResult edit(@RequestParam(value = "notifyId", required = false) Long notifyId){
        return studentNotifyClient.edit(notifyId);
    }
}
