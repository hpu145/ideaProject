package com.kaishengit.controller;

import com.kaishengit.pojo.Kaola;
import com.kaishengit.service.KaolaService;
import com.kaishengit.util.Page;
import com.kaishengit.util.RequestQuery;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/29.
 */

@Controller
@RequestMapping("/kaola")
public class KaolaController {

    @Autowired
    private KaolaService kaolaService;

    /**
     * 展示所有考拉对象列表
     * @param model
     * @return
     */
    @GetMapping
    public String showAll(Model model, HttpServletRequest request,
                          @RequestParam(required = false,name = "p",defaultValue = "1")Integer pageNum)
            throws IllegalAccessException {
        List<RequestQuery> requestQueryList = RequestQuery.buildRequestQuery(request);
        Page<Kaola> kaolaList = kaolaService.findPageByRequestQuery(requestQueryList,pageNum);

        //List<Kaola> kaolaList = kaolaService.findByRequestQuery(requestQueryList);
        //List<Kaola> kaolaList = kaolaService.findAll();
        model.addAttribute("page",kaolaList);
        return "list";
    }

    /**
     * 添加对象
     */
    @GetMapping("/new")
    public String saveKaola() {
        return "new";
    }

    @PostMapping("/new")
    public String saveKaola(Kaola kaola) {
        kaolaService.saveKaola(kaola);
        return "redirect:/kaola";
    }

    /**
     * 展示商品详情
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    public String showKaola(@PathVariable Integer id, Model model) {
        Kaola kaola = kaolaService.findById(id);
        model.addAttribute("kaola",kaola);
        return "kaola";
    }



}
