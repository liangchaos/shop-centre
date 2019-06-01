package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.Permission;
import com.liangchao.shop.service.repository.PermissionRepository;
import com.liangchao.shop.service.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Description: FileManager 业务处理层
 * User: Administrator-LiangChao
 */
@Service
@Transactional
public class PermissionServiceImpl extends BaseServiceImpl<Permission, Long> implements PermissionService<Permission, Long> {
    // @Autowired
    public PermissionRepository permissionRepository;

    @Autowired
    public void setPermissionRepository (PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
        this.setImplementation (permissionRepository);
    }
}
