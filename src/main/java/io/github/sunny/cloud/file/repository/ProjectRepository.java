/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.repository;

import io.github.sunny.cloud.file.model.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 操作{@link ProjectModel}接口
 *
 * @author zhaoyunxing92
 * @link porject
 * @date: 2020-04-06 21:50
 */
@Repository
public interface ProjectRepository extends MongoRepository<ProjectModel, String> {
}
