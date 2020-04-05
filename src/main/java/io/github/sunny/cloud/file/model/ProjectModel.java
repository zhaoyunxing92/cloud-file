/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 项目实体类
 * @author zhaoyunxing92
 * @date: 2020-04-05 15:35
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "project")
public class ProjectModel extends BaseModel{
}
