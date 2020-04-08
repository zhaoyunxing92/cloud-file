/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.controller.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author zhaoyunxing92
 * @date: 2020-04-05 21:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AccountForm extends BaseForm {
    /**
     * 微信用户的openid
     */
    @NotBlank(message = "请输入openid")
    private String openId;
    /**
     * 用户名,唯一索引
     */
    @NotBlank(message = "请输入用户名")
    private String userName;

//    /**
//     * 邮箱
//     */
//    @NotBlank(message = "请输入邮箱")
//    private String emil;
//
//    /**
//     * 手机号
//     */
//    private String mobile;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 性别 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer gender = 0;
}
