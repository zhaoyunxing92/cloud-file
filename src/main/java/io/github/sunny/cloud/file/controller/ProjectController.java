/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.controller;

import io.github.sunny.cloud.file.controller.form.ProjectForm;
import io.github.sunny.cloud.file.model.ProjectModel;
import io.github.sunny.cloud.file.result.Response;
import io.github.sunny.cloud.file.service.ProjectService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目控制器
 *
 * @author zhaoyunxing92
 * @date: 2020-04-06 21:44
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {this.projectService = projectService;}

    /**
     * 添加项目
     *
     * @param form 表单数据
     * @return ProjectModel
     */
    @PutMapping
    public Response<ProjectModel> addProject(@RequestBody @Validated ProjectForm form) {
        return projectService.insert(form);
    }
    //修改
    //删除
    //查询
}
