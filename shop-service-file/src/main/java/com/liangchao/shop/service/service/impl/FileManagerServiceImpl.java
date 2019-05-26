package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.FileManager;
import com.liangchao.shop.service.repository.FileManagerRepository;
import com.liangchao.shop.service.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Description: FileManager 业务处理层
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 22:38
 * <br>
 * StringMatcher 参数
 * Matching	生成的语句	说明
 * DEFAULT (case-sensitive)	        firstname = ?0	                            默认（大小写敏感）
 * DEFAULT (case-insensitive)	    LOWER(firstname) = LOWER(?0)	            默认（忽略大小写）
 * EXACT (case-sensitive)	        firstname = ?0	                            精确匹配（大小写敏感）
 * EXACT (case-insensitive)	        LOWER(firstname) = LOWER(?0)	            精确匹配（忽略大小写）
 * STARTING (case-sensitive)	    firstname like ?0 + ‘%’	                    前缀匹配（大小写敏感）
 * STARTING (case-insensitive)	    LOWER(firstname) like LOWER(?0) + ‘%’	    前缀匹配（忽略大小写）
 * ENDING (case-sensitive)	        firstname like ‘%’ + ?0	                    后缀匹配（大小写敏感）
 * ENDING (case-insensitive)	    LOWER(firstname) like ‘%’ + LOWER(?0)	    后缀匹配（忽略大小写）
 * CONTAINING (case-sensitive)	    firstname like ‘%’ + ?0 + ‘%’	            模糊查询（大小写敏感）
 * CONTAINING (case-insensitive)	LOWER(firstname) like ‘%’ + LOWER(?0) + ‘%’	模糊查询（忽略大小写）
 * 说明：
 * 1. 在默认情况下（没有调用withIgnoreCase()）都是大小写敏感的。
 * 2. api之中还有个regex，但是我在mysql下测试报错，不了解具体作用。
 */
@Service
public class FileManagerServiceImpl implements FileManagerService<FileManager> {
    @Autowired
    public FileManagerRepository fileManagerRepository;

    @Override
    public boolean delete (Long id) {
        fileManagerRepository.deleteById (id);
        return true;
    }

    @Override
    public boolean delete (List<Long> idList) {
        List<FileManager> list = new ArrayList<> ();
        for (Long id : idList) {
            list.add (new FileManager ().setId (id));
        }
        fileManagerRepository.deleteAll ();
        return true;
    }

    @Override
    public FileManager findById (Long id) {
        return fileManagerRepository.findById (id).get ();
    }

    @Override
    public Page<FileManager> findByList (Pageable pageable, FileManager entity) {
        // @formatter:off
        ExampleMatcher exampleMatcher = ExampleMatcher.matching ()
                .withMatcher ("name", ExampleMatcher.GenericPropertyMatchers.contains ())
                .withMatcher ("type",ExampleMatcher.GenericPropertyMatchers.exact ())
                .withMatcher ("size",ExampleMatcher.GenericPropertyMatchers.exact ())
                .withMatcher ("source",ExampleMatcher.GenericPropertyMatchers.exact ())
                .withMatcher ("userSource",ExampleMatcher.GenericPropertyMatchers.exact ())
                ;
        // @formatter:on

        Example<FileManager> example = Example.of (entity, exampleMatcher);
        return fileManagerRepository.findAll (example, pageable);
    }

    @Override
    public boolean sava (FileManager entity) {
        fileManagerRepository.save (entity);
        return true;
    }
}
