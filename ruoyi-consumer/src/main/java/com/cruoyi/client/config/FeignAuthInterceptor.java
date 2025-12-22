package com.cruoyi.client.config;

import com.cruoyi.common.constant.Constants;
import com.cruoyi.common.utils.StringUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Feign请求拦截器：自动透传前端的token到服务端
 */
@Component
public class FeignAuthInterceptor implements RequestInterceptor {

    @Value("${token.header:Authorization}") // 默认值Authorization，防止配置缺失
    private String tokenHeader;
    @Override
    public void apply(RequestTemplate template) {
        // 获取当前请求上下文（前端请求客户端的请求）
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();

        // 从请求头获取token（若依默认的Authorization头）
        String token = request.getHeader(tokenHeader);
        if (StringUtils.isNotBlank(token)) {
            // 3. 透传token到服务端（请求头名称和服务端一致）
            template.header(tokenHeader, token);
        }
    }
}