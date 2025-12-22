package com.cruoyi.csystem;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.domain.model.LoginBody;
import com.cruoyi.feign.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Set;
@RestController
public class LoginController {
    @Autowired
    private LoginClient loginClient;

    @PostMapping("/login")
    public AjaxResult login (@RequestBody LoginBody loginBody)
    {
        return loginClient.login(loginBody);
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        return loginClient.getInfo();
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        return loginClient.getRouters();
    }

    // 检查初始密码是否提醒修改

}
