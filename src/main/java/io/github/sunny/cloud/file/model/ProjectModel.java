/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.model;

import io.github.sunny.cloud.file.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 项目实体类
 *
 * @author zhaoyunxing92
 * @date: 2020-04-05 15:35
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "project")
public class ProjectModel extends BaseModel<String> {
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目名称颜色
     */
    private String nameColor;
    /**
     * 项目描述
     */
    private String desc;
    /**
     * 背景颜色
     */
    private String bgColor;

    /**
     * 创建者
     */
    private AccountModel creator;
    /**
     * 管理者
     */
    private AccountModel managers;
}
