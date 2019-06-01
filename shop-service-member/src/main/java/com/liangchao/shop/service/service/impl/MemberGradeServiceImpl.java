package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.MemberGrade;
import com.liangchao.shop.service.repository.MemberGradeRepository;
import com.liangchao.shop.service.service.MemberGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Description: FileManager 业务处理层
 * User: Administrator-LiangChao
 */
@Service
@Transactional
public class MemberGradeServiceImpl extends BaseServiceImpl<MemberGrade, Long> implements MemberGradeService<MemberGrade, Long> {
    //    @Autowired
    public MemberGradeRepository memberGradeRepository;

    @Autowired
    public void setMemberGradeRepository (MemberGradeRepository memberGradeRepository) {
        this.memberGradeRepository = memberGradeRepository;
        this.setImplementation (memberGradeRepository);
    }
}
