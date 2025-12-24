package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.domain.dto.AnnouncementDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 管理员通知Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "adminNotifyClient")
public interface AdminNotifyClient {

    /**
     * 获取当前正考/补考开关状态
     */
    @GetMapping("/system/adminNotify/gradeStatus")
    AjaxResult getGradeEntryStatus();

    /**
     * 开启正考成绩录入
     */
    @PostMapping("/system/adminNotify/openFinal")
    AjaxResult openFinalGradeEntry();

    /**
     * 关闭正考成绩录入
     */
    @PostMapping("/system/adminNotify/closeFinal")
    AjaxResult closeFinalGradeEntry();

    /**
     * 开启补考成绩录入
     */
    @PostMapping("/system/adminNotify/openResit")
    AjaxResult openResitGradeEntry();

    /**
     * 关闭补考成绩录入
     */
    @PostMapping("/system/adminNotify/closeResit")
    AjaxResult closeResitGradeEntry();

    /**
     * 发送系统公告
     */
    @PostMapping("/system/adminNotify/sendAnnouncement")
    AjaxResult sendAnnouncement(@RequestBody AnnouncementDTO dto);
}
