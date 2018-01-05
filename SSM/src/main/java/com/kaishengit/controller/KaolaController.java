package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaType;
import com.kaishengit.service.KaolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zhangyu on 2017/11/4.
 */
@Controller
@RequestMapping("/product")
public class KaolaController {

    @Autowired
    private KaolaService kaolaService;


    /**
     * 查找全部商品列表，搜索框功能
     * @param pageNo
     * @param productName
     * @param place
     * @param typeId
     * @param model
     * @return
     */
    @GetMapping
    public String list(@RequestParam(required = false,defaultValue = "1",name = "p")Integer pageNo,
                       @RequestParam(required = false,defaultValue = "")String productName,
                       @RequestParam(required = false,defaultValue = "")String place,
                       @RequestParam(required = false,defaultValue = "")Integer typeId,
                       @RequestParam(required = false,defaultValue = "")BigDecimal minPrice,
                       @RequestParam(required = false,defaultValue = "")BigDecimal maxPrice,
                       Model model) {
        Map<String,Object> searchParam = new HashMap<>();
        searchParam.put("productName",productName);
        searchParam.put("place",place);
        searchParam.put("typeId",typeId);
        searchParam.put("minPrice",minPrice);
        searchParam.put("maxPrice",maxPrice);

        PageInfo<Kaola> pageInfo = kaolaService.findByPageNo(pageNo,searchParam);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("placeList",kaolaService.findPlaceList());
        model.addAttribute("typeList",kaolaService.findAllType());
        return "product/list";
    }

    @GetMapping("/{id:\\d+}")
    public String show(@PathVariable Integer id,Model model) {
        Kaola kaola = kaolaService.findById(id);
        model.addAttribute("kaola",kaola);
        return "product/show";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        List<KaolaType> kaolaTypes = kaolaService.findAllType();
        model.addAttribute("kaolaTypes",kaolaTypes);
        return "product/new";
    }

    @PostMapping("/new")
    public String newProduct(Kaola kaola, RedirectAttributes redirectAttributes) {
        kaolaService.save(kaola);
        redirectAttributes.addFlashAttribute("message","商品添加成功");
        return "redirect:/product";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String editProduct(@PathVariable Integer id,Model model) {
        model.addAttribute("kaola",kaolaService.findById(id));
        model.addAttribute("kaolaTypes",kaolaService.findAllType());
        return "product/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String editProduct(Kaola kaola,RedirectAttributes redirectAttributes) {
        kaolaService.edit(kaola);
        redirectAttributes.addFlashAttribute("message","商品修改成功");
        return "redirect:/product/" + kaola.getId();
    }

    @GetMapping("/{id:\\d+}/delete")
    public String deleteProduct(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        kaolaService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","商品删除成功");
        return "redirect:/product";
    }




}
