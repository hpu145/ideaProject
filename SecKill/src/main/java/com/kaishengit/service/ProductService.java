package com.kaishengit.service;

import com.kaishengit.entity.Product;

import java.io.InputStream;
import java.util.List;

/**
 * Created by zhangyu on 2017/12/5.
 */
public interface ProductService {

    List<Product> findAll();

    void saveProduct(Product product, InputStream inputStream);

    Product findProductById(Integer id);

    void secKill(Integer id);
}
