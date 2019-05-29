package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.FileManager;
import com.liangchao.shop.entity.Member;
import com.liangchao.shop.service.repository.MemberRepository;
import com.liangchao.shop.service.service.MemberService;
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
public class MemberServiceImpl implements MemberService<Member> {
    @Autowired
    public MemberRepository memberRepository;

    @Override
    public boolean delete (Long id) {
        memberRepository.deleteById (id);
        return true;
    }

    @Override
    public boolean delete (List<Long> idList) {
        List<FileManager> list = new ArrayList<> ();
        for (Long id : idList) {
            list.add (new FileManager ().setId (id));
        }
        memberRepository.deleteAll ();
        return true;
    }

    @Override
    public Member findById (Long id) {
        return memberRepository.findById (id).get ();
    }

    @Override
    public Page<Member> findByList (Pageable pageable, Member entity) {
        // @formatter:off
        ExampleMatcher exampleMatcher = ExampleMatcher.matching ()
                .withMatcher ("name", ExampleMatcher.GenericPropertyMatchers.contains ())
                .withMatcher ("type",ExampleMatcher.GenericPropertyMatchers.exact ())
                .withMatcher ("size",ExampleMatcher.GenericPropertyMatchers.exact ())
                .withMatcher ("source",ExampleMatcher.GenericPropertyMatchers.exact ())
                .withMatcher ("userSource",ExampleMatcher.GenericPropertyMatchers.exact ())
                ;
        // @formatter:on

        Example<Member> example = Example.of (entity, exampleMatcher);
        return memberRepository.findAll (example, pageable);
    }

    @Override
    public boolean sava (Member entity) {
        memberRepository.save (entity);
        return true;
    }
}
