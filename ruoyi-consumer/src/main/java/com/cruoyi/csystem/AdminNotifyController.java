package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.domain.dto.AnnouncementDTO;
import com.cruoyi.feign.AdminNotifyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员通知Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/adminNotify")
public class AdminNotifyController extends BaseController {

    @Autowired
    private AdminNotifyClient adminNotifyClient;

    /**
     * 获取当前正考/补考开关状态
     */
    @GetMapping("/gradeStatus")
    public AjaxResult getGradeEntryStatus() {
        return adminNotifyClient.getGradeEntryStatus();
    }

    /**
     * 开启正考成绩录入
     */
    @PostMapping("/openFinal")
    public AjaxResult openFinalGradeEntry() {
        return adminNotifyClient.openFinalGradeEntry();
    }

    /**
     * 关闭正考成绩录入
     */
    @PostMapping("/closeFinal")
    public AjaxResult closeFinalGradeEntry() {
        return adminNotifyClient.closeFinalGradeEntry();
    }

    /**
     * 开启补考成绩录入
     */
    @PostMapping("/openResit")
    public AjaxResult openResitGradeEntry() {
        return adminNotifyClient.openResitGradeEntry();
    }

    /**
     * 关闭补考成绩录入
     */
    @PostMapping("/closeResit")
    public AjaxResult closeResitGradeEntry() {
        return adminNotifyClient.closeResitGradeEntry();
    }

    /**
     * 发送系统公告
     */
    @PostMapping("/sendAnnouncement")
    public AjaxResult sendAnnouncement(@RequestBody AnnouncementDTO dto) {
        return adminNotifyClient.sendAnnouncement(dto);
    }
}
