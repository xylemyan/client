package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ruoyi-server", url = "http://localhost:8081", contextId = "studentNotifyClient")
public interface StudentNotifyClient {
    //查询学生个人通知列表
    @GetMapping("/student.notification/notification/list")
    public TableDataInfo list(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) Long semester,
            @RequestParam(required = false) Long isRead,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,      // 添加页码
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize   // 添加页大
    );

    // 修改学生个人通知
    @PutMapping("/student.notification/notification")
    public AjaxResult edit(@RequestParam(value = "notifyId", required = false) Long notifyId);
}
