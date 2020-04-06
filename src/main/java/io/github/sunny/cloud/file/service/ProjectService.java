/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.service;

import io.github.sunny.cloud.file.controller.form.ProjectForm;
import io.github.sunny.cloud.file.model.ProjectModel;
import io.github.sunny.cloud.file.repository.ProjectRepository;
import io.github.sunny.cloud.file.result.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 项目服务
 *
 * @author zhaoyunxing92
 * @date: 2020-04-06 21:45
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {this.projectRepository = projectRepository;}

    /**
     * 添加项目
     *
     * @param form 表单数据
     * @return ProjectModel
     */
    public Response<ProjectModel> insert(ProjectForm form) {

        ProjectModel model = new ProjectModel();
        BeanUtils.copyProperties(form, model);
        projectRepository.insert(model);
        return Response.of(model);
    }
}
