/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.model.base;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础依赖
 *
 * @author zhaoyunxing92
 * @date: 2020-04-05 15:36
 */
@Data
public class BaseModel<T extends Serializable> implements Serializable {
    /**
     * 主键id
     */
    @Id
    private T id;

    /**
     * 状态 0=正常
     */
    private Integer status = 0;

    /**
     * 修改时间
     */
    private Date modifierTime;
    /**
     * 创建时间
     */
    private Date createTime;

}
