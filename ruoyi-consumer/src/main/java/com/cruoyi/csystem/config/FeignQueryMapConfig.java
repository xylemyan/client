package com.cruoyi.csystem.config;

import feign.QueryMapEncoder;
import feign.codec.EncodeException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 Feign QueryMapEncoder，忽略 params 字段
 */
@Configuration
public class FeignQueryMapConfig {

    @Bean
    public QueryMapEncoder queryMapEncoder() {
        return object -> {
            if (object == null) {
                return new HashMap<>();
            }
            Map<String, Object> queryMap = new HashMap<>();
            try {
                java.beans.BeanInfo beanInfo = java.beans.Introspector.getBeanInfo(object.getClass());
                for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
                    String name = pd.getName();
                    // 忽略 class、params、searchValue 字段
                    if ("class".equals(name) || "params".equals(name) || "searchValue".equals(name)) {
                        continue;
                    }
                    Method getter = pd.getReadMethod();
                    if (getter != null) {
                        Object value = getter.invoke(object);
                        if (value != null) {
                            queryMap.put(name, value);
                        }
                    }
                }
            } catch (Exception e) {
                throw new EncodeException("Failed to encode query map", e);
            }
            return queryMap;
        };
    }
}
