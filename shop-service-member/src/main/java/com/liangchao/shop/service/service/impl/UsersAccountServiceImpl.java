package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.UsersAccount;
import com.liangchao.shop.service.repository.UsersAccountRepository;
import com.liangchao.shop.service.service.UsersAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Description: FileManager 业务处理层
 * User: Administrator-LiangChao
 */
@Service
@Transactional
public class UsersAccountServiceImpl extends BaseServiceImpl<UsersAccount, Long> implements UsersAccountService<UsersAccount, Long> {
    // @Autowired
    public UsersAccountRepository usersAccountRepository;

    @Autowired
    public void setUsersAccountRepository (UsersAccountRepository usersAccountRepository) {
        this.usersAccountRepository = usersAccountRepository;
        this.setImplementation (usersAccountRepository);
    }
}
