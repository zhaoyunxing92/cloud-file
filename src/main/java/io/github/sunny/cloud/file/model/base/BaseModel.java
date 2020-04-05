/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * 基础依赖
 *
 * @author zhaoyunxing92
 * @date: 2020-04-05 15:36
 */
@Data
public class BaseModel {

    @Id
    private String id;
}
