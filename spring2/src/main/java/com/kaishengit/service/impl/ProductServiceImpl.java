package com.kaishengit.service.impl;

import com.kaishengit.dao.ProductDao;
import com.kaishengit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyu on 2017/10/30.
 */
@Component("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public void save() {
        productDao.save();
    }
}
