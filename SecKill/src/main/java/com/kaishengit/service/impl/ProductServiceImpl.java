package com.kaishengit.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.kaishengit.entity.Product;
import com.kaishengit.entity.ProductExample;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.mapper.ProductMapper;
import com.kaishengit.service.ProductService;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by zhangyu on 2017/12/5.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;
    @Value("${qiniu.ak}")
    private String qiniuAk;
    @Value("${qiniu.sk}")
    private String qiniuSK;
    @Value("${qiniu.buket}")
    private String qiniuBuket;
    @Autowired
    private JedisPool jedisPool;

    /**
     * 查找所有商品列表
     * @return
     */
    @Override
    public List<Product> findAll() {
        ProductExample productExample = new ProductExample();
        productExample.setOrderByClause("start_time asc");
        return productMapper.selectByExample(productExample);
    }

    /**
     * 添加商品
     * @param product
     * @param inputStream
     */
    @Override
    @Transactional
    public void saveProduct(Product product, InputStream inputStream) {
        //上传文件到七牛云
        Configuration configuration = new Configuration(Zone.zone1());
        UploadManager uploadManager = new UploadManager(configuration);
        Auth auth = Auth.create(qiniuAk,qiniuSK);
        String uploadToken = auth.uploadToken(qiniuBuket);
        String key = null;
        try {
            Response response = uploadManager.put(IOUtils.toByteArray(inputStream),null,uploadToken);
            DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
            key = defaultPutRet.key;
        } catch (IOException e) {
            throw new RuntimeException("上传文件到七牛异常",e);
        }

        //保存对象
        product.setProductImg(key);
        productMapper.insertSelective(product);
    }

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @Override
    public Product findProductById(Integer id) {
        Product product;
        try(Jedis jedis = jedisPool.getResource()) {
            String json = jedis.get("product:" + id);
            if (json == null) {
                product = productMapper.selectByPrimaryKey(id);
                jedis.set("product:" + id, JSON.toJSONString(product));
            } else {
                product = JSON.parseObject(json,Product.class);
            }
        }
        return product;
    }

    /**
     * 抢购商品
     * @param id
     */
    @Override
    public void secKill(Integer id) {








       /* //1.查询商品
        Product product = productMapper.selectByPrimaryKey(id);
        //2.判断是否有库存
        if(product.getProductInventory() > 0) {

            product.setProductInventory(product.getProductInventory() - 1);
            productMapper.updateByPrimaryKey(product);
            logger.info("秒杀商品成功");

        } else {
            logger.error("库存不足，秒杀失败");
            throw new ServiceException("抢光了");
        }*/

    }


}
