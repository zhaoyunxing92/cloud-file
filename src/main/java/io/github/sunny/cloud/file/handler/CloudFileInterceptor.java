/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.handler;

import com.alibaba.fastjson.JSONObject;
import io.github.sunny.cloud.file.model.AccountModel;
import io.github.sunny.cloud.file.model.base.UserModel;
import io.github.sunny.cloud.file.result.Response;
import io.github.sunny.cloud.file.service.AccountService;
import io.github.sunny.cloud.file.utils.AccountThreadLocal;
import io.github.sunny.cloud.file.utils.SpringBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

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
     * @param req
     * @param res
     * @param handler
     * @return true or false false:拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        res.setHeader("Content-type", "application/json;charset=UTF-8");
        res.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String token = req.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            AccountService accountService = SpringBeanUtils.getBean(AccountService.class);

            Response<AccountModel> resp = accountService.getAccountById(token);
            AccountModel account = resp.getData();
            if (account == null) {
                res.setStatus(UNAUTHORIZED.value());
                res.getWriter().write(JSONObject.toJSONString(Response.of(-402, "请先登录")));
                return false;
            }
            //清除冗余数据
            UserModel user = new UserModel();
            BeanUtils.copyProperties(account, user);
            AccountThreadLocal.set(user);
            return true;
        } else {
            res.setStatus(UNAUTHORIZED.value());
            res.getWriter().write(JSONObject.toJSONString(Response.of(-401, "请先登录")));
            return false;
        }
    }
}
