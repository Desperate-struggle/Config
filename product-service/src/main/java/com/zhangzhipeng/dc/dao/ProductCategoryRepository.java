package com.zhangzhipeng.dc.dao;

import com.zhangzhipeng.dc.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>, JpaSpecificationExecutor {

}
