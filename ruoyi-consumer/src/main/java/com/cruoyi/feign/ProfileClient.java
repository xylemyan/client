package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 个人信息Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "profileClient")
public interface ProfileClient {

    /**
     * 个人信息
     */
    @GetMapping("/system/user/profile")
    AjaxResult profile();

    /**
     * 修改用户
     */
    @PutMapping("/system/user/profile")
    AjaxResult updateProfile(@RequestBody SysUser user);

    /**
     * 重置密码
     */
    @PutMapping("/system/user/profile/updatePwd")
    AjaxResult updatePwd(@RequestBody Map<String, String> params);

    /**
     * 头像上传
     */
    @PostMapping(value = "/system/user/profile/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    AjaxResult avatar(@RequestPart("avatarfile") MultipartFile file);
}
