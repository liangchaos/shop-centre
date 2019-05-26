package com.liangchao.shop.service.service;

import com.liangchao.shop.entity.FileManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 22:40
 */
public interface FileManagerService<T> {

    boolean delete (Long id);

    boolean delete (List<Long> idList);

    T findById (Long id);

    Page<T> findByList (Pageable pageable, T entity);

    boolean sava (T entity);
}
