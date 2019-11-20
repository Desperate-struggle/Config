package com.zhangzhipeng.dc.service;


import com.zhangzhipeng.dc.dao.ProductCategoryRepository;
import com.zhangzhipeng.dc.dao.ProductInfoRepository;
import com.zhangzhipeng.dc.entity.ProductCategory;
import com.zhangzhipeng.dc.entity.ProductInfo;
import com.zhangzhipeng.dc.util.DataTranferTool;
import com.zhangzhipeng.dc.vo.BuyerProductInfoVO;
import com.zhangzhipeng.dc.vo.FoodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.MapAttribute;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductCategoryRepository categoryRepository;


    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Override
    public Page<ProductInfo> query(Integer page, Integer rows, String name, String pname, String dt1s, String dt1e, String dt2s, String dt2e, String minprice, String maxprice, Integer category_type) {

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();

                if (!StringUtils.isEmpty(name)){
                    Predicate productName = criteriaBuilder.like(root.get("productName"), '%' + name + '%');
                    list.add(productName);
                }
                if (!StringUtils.isEmpty(minprice)&&!StringUtils.isEmpty(maxprice)){
                    Predicate productPrice = criteriaBuilder.between(root.get("productPrice"), minprice, maxprice);
                    list.add(productPrice);
                }
                if (!StringUtils.isEmpty(category_type)){
                    Predicate category_type1 = criteriaBuilder.equal(root.get("category_type"), category_type);
                    list.add(category_type1);
                }
                if (!StringUtils.isEmpty(pname)){
                    Predicate propName = criteriaBuilder.equal(root.get("propName"), pname);
                    if (!StringUtils.isEmpty(dt1s)&&!StringUtils.isEmpty(dt1e)){
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try {
                            Date date1 = simpleDateFormat.parse(dt1s);
                            Date date2 = simpleDateFormat.parse(dt1e);
                            Predicate between = criteriaBuilder.between(root.get((MapAttribute) propName), date1, date2);
                            list.add(between);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Predicate[] predicates = new Predicate[list.size()];
                Predicate[] predicates1 = list.toArray(predicates);
                Predicate and = criteriaBuilder.and(predicates1);
                return and;
            }
        };
        PageRequest pageRequest = PageRequest.of(page - 1, rows);
        return productInfoRepository.findAll(specification,pageRequest);
    }

    ProductInfo add(ProductInfo productInfo){
        return productInfoRepository.save(productInfo);
    }


}
