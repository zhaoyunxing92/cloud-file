/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.service;

import com.alibaba.fastjson.JSONObject;
import io.github.sunny.cloud.file.controller.form.AccountForm;
import io.github.sunny.cloud.file.model.AccountModel;
import io.github.sunny.cloud.file.result.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaoyunxing92
 * @date: 2020-04-05 17:31
 */
@Service
public class WechatService {

    private final RestTemplate restTemplate;
    private final AccountService accountService;

    public WechatService(RestTemplate restTemplate, AccountService accountService) {
        this.restTemplate = restTemplate;
        this.accountService = accountService;
    }

    @Value("${wechat.appId:''}")
    private String appId;

    @Value("${wechat.appSecret:''}")
    private String appSecret;


    /**
     * {"openid":"oi1wA0WNmY7R0JoAxRMGeGEEFUGw","session_key":"wZHMUjf8dtBAlJgw/ac+rg==","expires_in":7200}
     * @param code 小程序code码
     * @return openid
     */
    public Response<AccountModel> getAccountByCode(String code) {
        StringBuilder sb = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        sb.append("appId=")
                .append(appId)
                .append("&secret=")
                .append(appSecret)
                .append("&js_code=")
                .append(code)
                .append("&grant_type=authorization_code");
        String json = restTemplate.getForObject(sb.toString(), String.class);

        JSONObject jsonObject = JSONObject.parseObject(json);

        int errCode = jsonObject.getIntValue("errcode");

        switch (errCode) {
            case 0:
                String openId = jsonObject.getString("openid");
                Response<AccountModel> res = accountService.getAccountByOpenId(openId);
                AccountModel account = res.getData();
                if (account != null) {
                    return Response.of("openid登录成功", account);
                } else {
                    account = new AccountModel();
                    account.setOpenId(openId);
                    return Response.of(401, "获取openid成功", account);
                }
            case -1:
                return Response.of(-1, "系统繁忙，此时请开发者稍候再试");
            case 40029:
                return Response.of(-2, String.format("[%s]无效", code));
            case 45011:
                return Response.of(-3, "频率限制，每个用户每分钟100次");
            default:
                return Response.of(-4, "未知异常");
        }
    }

    /**
     * 注册
     *
     * @param form 账号信息
     * @return
     */
    public Response register(AccountForm form) {

        return null;
    }
}
