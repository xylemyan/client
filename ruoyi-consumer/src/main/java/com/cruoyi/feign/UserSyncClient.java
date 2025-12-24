package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 用户同步Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "userSyncClient")
public interface UserSyncClient {

    /**
     * 同步所有教师
     */
    @PostMapping("/system/userSync/syncTeachers")
    AjaxResult syncTeachers();

    /**
     * 同步所有学生
     */
    @PostMapping("/system/userSync/syncStudents")
    AjaxResult syncStudents();

    /**
     * 同步所有管理员
     */
    @PostMapping("/system/userSync/syncAdmins")
    AjaxResult syncAdmins();

    /**
     * 同步所有用户（一键同步）
     */
    @PostMapping("/system/userSync/syncAll")
    AjaxResult syncAll();
}
