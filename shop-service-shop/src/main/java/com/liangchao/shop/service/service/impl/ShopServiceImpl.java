package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.Shop;
import com.liangchao.shop.service.repository.ShopRepository;
import com.liangchao.shop.service.service.ShopService;
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
 */
@Service
public class ShopServiceImpl implements ShopService<Shop> {

    @Autowired
    public ShopRepository shopRepository;

    @Override
    public boolean delete (Long id) {
        shopRepository.deleteById (id);
        return true;
    }

    @Override
    public boolean delete (List<Long> idList) {
        List<Shop> list = new ArrayList<> ();
        // for (Long id : idList) {
        //     list.add (new Shop ().setId (id));
        // }
        shopRepository.deleteAll ();
        return true;
    }

    @Override
    public Shop findById (Long id) {
        return shopRepository.findById (id).get ();
    }

    @Override
    public Page<Shop> findByList (Pageable pageable, Shop entity) {
        // @formatter:off
        ExampleMatcher exampleMatcher = ExampleMatcher.matching ()
                // .withMatcher ("name", ExampleMatcher.GenericPropertyMatchers.contains ())
                // .withMatcher ("type",ExampleMatcher.GenericPropertyMatchers.exact ())
                // .withMatcher ("size",ExampleMatcher.GenericPropertyMatchers.exact ())
                // .withMatcher ("source",ExampleMatcher.GenericPropertyMatchers.exact ())
                // .withMatcher ("userSource",ExampleMatcher.GenericPropertyMatchers.exact ())
                ;
        // @formatter:on

        Example<Shop> example = Example.of (entity, exampleMatcher);
        return shopRepository.findAll (example, pageable);
    }

    @Override
    public boolean sava (Shop entity) {
        shopRepository.save (entity);
        return true;
    }
}
