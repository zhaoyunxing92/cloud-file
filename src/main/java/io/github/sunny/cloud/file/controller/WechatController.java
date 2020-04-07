/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.controller;

import io.github.sunny.cloud.file.controller.form.AccountForm;
import io.github.sunny.cloud.file.service.AccountService;
import io.github.sunny.cloud.file.service.WechatService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 微信模块控制器
 *
 * @author zhaoyunxing92
 * @date: 2020-04-05 17:21
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {

    private final WechatService wechatService;
    private final AccountService accountService;

    public WechatController(WechatService wechatService, AccountService accountService) {
        this.wechatService = wechatService;
        this.accountService = accountService;
    }

    /**
     * 通过小程序code获取用户信息
     *
     * @param code 小程序生成的code
     * @return openid
     */
    @GetMapping("/{code}")
    public ResponseEntity<Object> getAccountByCode(@PathVariable String code) {
        return ResponseEntity.ok(wechatService.getAccountByCode(code));
    }

    /**
     * 注册活登录小程序用户
     *
     * @param form 表单数据
     * @return openid
     */
    @PostMapping("/register")
    public ResponseEntity<Object> registerOrLogin(@RequestBody @Validated AccountForm form) {
        return ResponseEntity.ok(accountService.registerOrLogin(form));
    }
}
