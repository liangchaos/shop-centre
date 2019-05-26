package com.liangchao.shop.service.repository;

import com.liangchao.shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 22:42
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
