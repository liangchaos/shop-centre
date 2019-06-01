package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.service.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Description: BaseService实现
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 18:15
 */
public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    private JpaRepository<T, ID> implementation;

    /** 测试使用 **/
    @Override
    public JpaRepository<T, ID> getImplementation () {
        return implementation;
    }

    /** 设置持久接口 **/
    public void setImplementation (JpaRepository<T, ID> implementation) {
        this.implementation = implementation;
    }

    @Override
    public boolean delete (ID id) {
        implementation.deleteById (id);
        return true;
    }

    @Override
    public boolean delete (List<ID> ids) {
        return false;
    }

    @Override
    public T findById (ID id) {
        return implementation.findById (id).get ();
    }

    @Override
    public Page<T> findByList (Pageable pageable) {
        return implementation.findAll (pageable);
    }

    @Override
    public boolean sava (T entity) {
        implementation.save (entity);
        return true;
    }
}
