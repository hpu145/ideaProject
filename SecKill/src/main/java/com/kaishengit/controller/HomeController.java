package com.kaishengit.controller;

import com.kaishengit.controller.result.AjaxResult;
import com.kaishengit.entity.Product;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyu on 2017/12/5.
 */
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    /**
     * 首页 商品列表
     * @return
     */
    @GetMapping("/home")
    public String homePage(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "home";
    }

    /**
     * 添加新的商品
     * @return
     */
    @GetMapping("/product/new")
    public String newProduct() {
        return "new";
    }
    @PostMapping("/product/new")
    public String newProduct(Product product, MultipartFile image) {
        if (image.isEmpty()) {
            productService.saveProduct(product,null);
        } else {
            try {
                productService.saveProduct(product,image.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/home";
    }

    /**
     * 根据id查找商品
     * @param id
     * @return
     */
    @GetMapping("/product/{id:\\d+}")
    public String findProductById(@PathVariable Integer id,Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product",product);
        return "product";
    }

    /**
     * 抢购商品
     */
    @GetMapping("/product/seckill/{id:\\d+}")
    @ResponseBody
    public AjaxResult secKill(@PathVariable Integer id) {
        try {
            productService.secKill(id);
            return AjaxResult.success();
        } catch (ServiceException ex) {
            return AjaxResult.error(ex.getMessage());
        }
    }









}
