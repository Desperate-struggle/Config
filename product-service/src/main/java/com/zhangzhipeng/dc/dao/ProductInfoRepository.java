package com.zhangzhipeng.dc.dao;

import com.zhangzhipeng.dc.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>, JpaSpecificationExecutor {

}
