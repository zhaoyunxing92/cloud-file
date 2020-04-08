/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.controller;

import io.github.sunny.cloud.file.controller.form.ProjectForm;
import io.github.sunny.cloud.file.model.ProjectModel;
import io.github.sunny.cloud.file.result.Response;
import io.github.sunny.cloud.file.service.ProjectService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 更新项目
     *
     * @param id   项目id
     * @param form 表单数据
     * @return ProjectModel
     */
    @PutMapping("/{id}")
    public Response<ProjectModel> updateProject(@PathVariable String id, @RequestBody @Validated ProjectForm form) {

        return projectService.update(id, form);
    }

    /**
     * 获取 项目列表
     *
     * @return List<ProjectModel>
     */
    @GetMapping
    public Response<List<ProjectModel>> projects() {
        return projectService.projects();
    }


    //修改
    //删除
}
