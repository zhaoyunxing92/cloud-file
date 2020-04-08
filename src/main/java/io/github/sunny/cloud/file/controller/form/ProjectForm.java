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
 * @date: 2020-04-06 21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ProjectForm extends BaseForm {
    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称必填")
    private String name;
    /**
     * 项目名称颜色
     */
    private String nameColor;
    /**
     * 项目描述
     */
    @NotBlank(message = "项目描述必填")
    private String desc;
}
