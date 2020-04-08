/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.controller.form;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaoyunxing92
 * @date: 2020-04-08 16:53
 */
@Data
public class BaseForm implements Serializable {
    /**
     * 修改时间
     */
    private Date modifierTime = new Date();
    /**
     * 创建时间
     */
    private Date createTime = new Date();

}
