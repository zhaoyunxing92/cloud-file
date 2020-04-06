/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.controller;

import io.github.sunny.cloud.file.model.AccountModel;
import io.github.sunny.cloud.file.result.Response;
import io.github.sunny.cloud.file.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账号
 *
 * @author zhaoyunxing92
 * @date: 2020-04-05 23:36
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {this.accountService = accountService;}

    /**
     * 检查账号是否可用
     *
     * @param account 账号
     * @return Response
     */
    @GetMapping("/check/{account}")
    public Response<String> checkUserName(@PathVariable String account) {
        Response<AccountModel> res = accountService.getAccountByUserName(account);
        if (res.getData() != null) {
            return Response.of(-8, String.format("账号[%s]已经注册", account));
        }
        return Response.of(String.format("账号[%s]可以使用", account));
    }
}
