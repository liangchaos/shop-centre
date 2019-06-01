package com.liangchao.shop.service.service.impl;

import com.liangchao.shop.entity.IntegralHistory;
import com.liangchao.shop.service.repository.IntegralHistoryRepository;
import com.liangchao.shop.service.service.IntegralHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 19:41
 */
@Service
@Transactional
public class IntegralHistoryServiceImpl extends BaseServiceImpl<IntegralHistory, Long> implements IntegralHistoryService<IntegralHistory, Long> {

    //@Autowired
    private IntegralHistoryRepository integralHistoryRepository;

    @Autowired
    public void setIntegralHistoryRepository (IntegralHistoryRepository integralHistoryRepository) {
        this.integralHistoryRepository = integralHistoryRepository;
        this.setImplementation (integralHistoryRepository);
    }
}
