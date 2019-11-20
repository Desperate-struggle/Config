package com.zhangzhipeng.dc.controller;


import com.zhangzhipeng.dc.entity.ProductInfo;
import com.zhangzhipeng.dc.service.ProductService;
import com.zhangzhipeng.dc.vo.BuyerProductInfoVO;
import com.zhangzhipeng.dc.vo.CodeMsg;
import com.zhangzhipeng.dc.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("list")
    public Page<ProductInfo> query(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "rows",defaultValue = "3") Integer rows,
                                   String name, String pname, String dt1s, String dt1e, String dt2s,
                                   String dt2e, String minprice, String maxprice, Integer category_type){
        return service.query(page,rows,name,pname,dt1s,dt1e,dt2s,dt2e,minprice,maxprice,category_type);
    }

}
