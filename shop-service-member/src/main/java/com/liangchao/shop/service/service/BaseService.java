package com.liangchao.shop.service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;
/**
 * Description:Service 基类
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 18:13
 */
public interface BaseService<T, ID> {

    /** 获取持久层 测试 **/
    JpaRepository<T, ID> getImplementation ();

    boolean delete (ID id);

    boolean delete (List<ID> idList);

    T findById (ID id);

    Page<T> findByList (Pageable pageable);

    boolean sava (T entity);

}
