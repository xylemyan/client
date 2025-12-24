package com.cruoyi.csystem.config;

import feign.Client;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * OpenFeign HTTPS 配置（开发环境信任自签名证书）
 * 生产环境请删除此类，使用正规 CA 证书（无需信任配置）
 */
@Configuration
public class FeignHttpsConfig {

    /**
     * 配置 Feign 信任所有证书（开发环境仅！）
     */
    @Bean
    public Client feignClient() {
        // 信任策略：允许所有证书（开发环境临时方案）
        TrustStrategy trustAllStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        };

        try {
            // 构建 SSL 上下文
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(null, trustAllStrategy)
                    .build();
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // 配置 Feign 客户端使用自定义 SSL 上下文，忽略域名校验（开发环境）
            return new Client.Default(sslSocketFactory, new NoopHostnameVerifier());
        } catch (Exception e) {
            throw new RuntimeException("Feign HTTPS 配置失败", e);
        }
    }
}