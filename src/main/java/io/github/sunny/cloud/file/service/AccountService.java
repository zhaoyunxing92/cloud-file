/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.service;

import io.github.sunny.cloud.file.controller.form.AccountForm;
import io.github.sunny.cloud.file.model.AccountModel;
import io.github.sunny.cloud.file.repository.AccountRepository;
import io.github.sunny.cloud.file.result.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * @author zhaoyunxing92
 * @date: 2020-04-05 15:43
 */
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {this.accountRepository = accountRepository;}

    /**
     * 添加账号
     *
     * @param form 表单数据
     * @return
     */
    public Response<AccountModel> insertAccount(AccountForm form) {
        //检查用户名是否存在
        String userName = form.getUserName();
        Response<AccountModel> res = getAccountByUserName(userName);
        if (res.getData() != null) {
            return Response.of(-6, String.format("账号[%s]已经存在", userName));
        }

        //检查openid是否存在
        String openId = form.getOpenId();
        res = getAccountByOpenId(openId);
        if (res.getData() != null) {
            return Response.of(-7, String.format("openid[%s]已经存在", openId));
        }

        try {
            AccountModel model = new AccountModel();
            BeanUtils.copyProperties(form, model);
            accountRepository.insert(model);
            return Response.of(model);
        } catch (Exception ex) {
            return Response.of(-5, ex.getMessage());
        }
    }

    /**
     * 根据id查询
     *
     * @param id 账号id
     * @return AccountModel
     */
    public Response<AccountModel> getAccountById(String id) {
        Optional<AccountModel> opt = accountRepository.findById(id);
        AccountModel model = opt.orElse(null);
        return Response.of(model);
    }

    /**
     * 根据id查询
     *
     * @param openId 小程序的openid
     * @return AccountModel
     */
    public Response<AccountModel> getAccountByOpenId(String openId) {
        Optional<AccountModel> opt = accountRepository.findAccountModelByOpenId(openId);
        AccountModel model = opt.orElse(null);
        return Response.of(model);
    }

    /**
     * 根据userName查询
     *
     * @param userName 用户名
     * @return AccountModel
     */
    public Response<AccountModel> getAccountByUserName(String userName) {
        Optional<AccountModel> opt = accountRepository.findAccountModelByUserName(userName);
        AccountModel model = opt.orElse(null);
        return Response.of(model);
    }
    //根据token获取
    //注册

    //修改
    //删除
}
