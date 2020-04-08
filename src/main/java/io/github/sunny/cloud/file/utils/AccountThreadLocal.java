/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.utils;

import io.github.sunny.cloud.file.model.base.UserModel;

/**
 * @author zhaoyunxing92
 * @date: 2020-04-08 14:56
 */
public class AccountThreadLocal {

    private AccountThreadLocal() {
    }

    private static final ThreadLocal<UserModel> LOCAL = new ThreadLocal<>();

    /**
     * 保存用户信息
     *
     * @param account 账号信息
     */
    public static void set(UserModel account) {
        LOCAL.set(account);
    }

    /**
     * 获取
     *
     * @return AccountModel
     */
    public static UserModel get() {
        return LOCAL.get();
    }

    /**
     * 移除
     */
    public static void remove() {
        LOCAL.remove();
    }
}
