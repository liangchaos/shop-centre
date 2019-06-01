package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.Authorities;
import com.liangchao.shop.service.repository.AuthoritiesRepository;
import com.liangchao.shop.service.service.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 19:38
 */
@Service
@Transactional
public class AuthoritiesServiceImpl extends BaseServiceImpl<Authorities, Long> implements AuthoritiesService<Authorities, Long> {

    //@Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public void setAuthoritiesRepository (AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
        this.setImplementation (authoritiesRepository);
    }

}
