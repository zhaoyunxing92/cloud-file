/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 允许请求配置
 *
 * @author zhaoyunxing92
 * @date: 2020-04-04 23:48
 */
@Configuration
public class CloudFileWebMVCConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods("GET", "POST", "DELETE", "PUT").maxAge(3600);

    }
}
