/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.model.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaoyunxing92
 * @date: 2020-04-05 15:50
 */
@Data
public class UserModel implements Serializable {
    /**
     * 用户主键
     */
    private String id;
    /**
     * 微信用户的openid
     */
    private String openId;
    /**
     * 用户名,唯一索引
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 性别 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer gender = 0;
}
