/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author zhaoyunxing92
 * @date: 2020-04-05 16:38
 */
@Slf4j
public class CloudFileInterceptor implements HandlerInterceptor {
    /**
     * 请求执行前拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return true or false false:拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("url={}", request.getRequestURI());

        return true;
    }
}
