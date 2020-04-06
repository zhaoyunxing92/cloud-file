/**
 * Copyright(C) 2020 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cloud.file.repository;

import io.github.sunny.cloud.file.model.AccountModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 操作{@link AccountModel}接口
 *
 * @author zhaoyunxing92
 * @date: 2020-04-05 21:19
 */
@Repository
public interface AccountRepository extends MongoRepository<AccountModel, String> {
    /**
     * 根据用户名获取账号
     *
     * @param userName 账号名称
     * @return AccountModel
     */
    Optional<AccountModel> findAccountModelByUserName(String userName);

    /**
     * 根据openid获取账号
     *
     * @param openId openid
     * @return AccountModel
     */
    Optional<AccountModel> findAccountModelByOpenId(String openId);
}
