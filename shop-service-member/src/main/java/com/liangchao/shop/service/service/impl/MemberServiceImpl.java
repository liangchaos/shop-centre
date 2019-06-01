package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.Member;
import com.liangchao.shop.service.repository.MemberRepository;
import com.liangchao.shop.service.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Description: FileManager 业务处理层
 * User: Administrator-LiangChao
 */
@Service
@Transactional
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService<Member, Long> {
    //@Autowired
    public MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.setImplementation (memberRepository);
    }
}
