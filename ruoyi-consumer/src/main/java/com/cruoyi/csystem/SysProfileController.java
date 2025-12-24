package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.entity.SysUser;
import com.cruoyi.feign.ProfileClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 个人信息Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController {

    @Autowired
    private ProfileClient profileClient;

    /**
     * 个人信息
     */
    @GetMapping
    public AjaxResult profile() {
        return profileClient.profile();
    }

    /**
     * 修改用户
     */
    @PutMapping
    public AjaxResult updateProfile(@RequestBody SysUser user) {
        return profileClient.updateProfile(user);
    }

    /**
     * 重置密码
     */
    @PutMapping("/updatePwd")
    public AjaxResult updatePwd(@RequestBody Map<String, String> params) {
        return profileClient.updatePwd(params);
    }

    /**
     * 头像上传
     */
    @PostMapping("/avatar")
    public AjaxResult avatar(@RequestParam("avatarfile") MultipartFile file) {
        return profileClient.avatar(file);
    }
}
