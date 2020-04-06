/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.model;

import io.github.sunny.cloud.file.model.base.BaseModel;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;

/**
 * 账户实体类
 *
 * @author zhaoyunxing92
 * @date: 2020-04-05 15:38
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "account")
public class AccountModel extends BaseModel<String> {
    /**
     * 微信用户的openid
     */
    @Indexed(unique = true)
    private String openId;
    /**
     * 用户名,唯一索引
     */
    @Indexed(unique = true)
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    @Field("password")
    private String password;

    /**
     * 头像
     */
    @Field("avatar_url")
    private String avatarUrl;

    /**
     * 性别 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer gender = 0;

}
