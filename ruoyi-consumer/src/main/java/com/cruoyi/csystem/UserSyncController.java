package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.feign.UserSyncClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户同步Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/userSync")
public class UserSyncController extends BaseController {

    @Autowired
    private UserSyncClient userSyncClient;

    /**
     * 同步所有教师
     */
    @PostMapping("/syncTeachers")
    public AjaxResult syncTeachers() {
        return userSyncClient.syncTeachers();
    }

    /**
     * 同步所有学生
     */
    @PostMapping("/syncStudents")
    public AjaxResult syncStudents() {
        return userSyncClient.syncStudents();
    }

    /**
     * 同步所有管理员
     */
    @PostMapping("/syncAdmins")
    public AjaxResult syncAdmins() {
        return userSyncClient.syncAdmins();
    }

    /**
     * 同步所有用户（一键同步）
     */
    @PostMapping("/syncAll")
    public AjaxResult syncAll() {
        return userSyncClient.syncAll();
    }
}
