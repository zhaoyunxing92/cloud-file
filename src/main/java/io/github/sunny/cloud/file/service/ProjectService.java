/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.service;

import io.github.sunny.cloud.file.controller.form.ProjectForm;
import io.github.sunny.cloud.file.model.AccountModel;
import io.github.sunny.cloud.file.model.ProjectModel;
import io.github.sunny.cloud.file.model.base.UserModel;
import io.github.sunny.cloud.file.repository.ProjectRepository;
import io.github.sunny.cloud.file.result.Response;
import io.github.sunny.cloud.file.utils.AccountThreadLocal;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        UserModel user = AccountThreadLocal.get();
        model.setManagers(user);
        model.setCreator(user);
        projectRepository.insert(model);
        return Response.of(model);
    }

    /**
     * 获取全部项目
     *
     * @return List<ProjectModel>
     */
    public Response<List<ProjectModel>> projects() {

        return Response.of(projectRepository.findAll());
    }

    /**
     * 更新项目
     *
     * @param id   更新数据
     * @param form 表单数据
     * @return ProjectModel
     */
    public Response<ProjectModel> update(String id, ProjectForm form) {

        Optional<ProjectModel> opt = projectRepository.findById(id);
        ProjectModel model = opt.orElseGet(null);

        if (model == null) {
            return Response.of(-10, String.format("[%s]不存在", id));
        }
        BeanUtils.copyProperties(form, model);
        model.setId(id);
        //        String name = form.getName();
        //        if (!StringUtils.isEmpty(name)) {
        //            model.setName(name);
        //        }
        //
        //        String desc = form.getDesc();
        //        if (!StringUtils.isEmpty(desc)) {
        //            model.setDesc(desc);
        //        }


        projectRepository.save(model);
        return Response.of(model);
    }
}
