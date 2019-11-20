package com.zhangzhipeng.dc.service;


import com.zhangzhipeng.dc.entity.ProductInfo;
import com.zhangzhipeng.dc.vo.BuyerProductInfoVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Page<ProductInfo> query(Integer page,Integer rows,String name,String pname,
                            String dt1s,String dt1e,String dt2s,
                            String dt2e,String minprice,String maxprice,
                            Integer category_type);

}
