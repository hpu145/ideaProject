package com.kaishengit.tms.api;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.TicketStore;
import com.kaishengit.tms.service.ScenicService;
import com.kaishengit.tms.system.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * 分类统计信息控制器
 */
@Controller
public class SortController {

    @Autowired
    private ScenicService scenicService;
    @Autowired
    private StoreInfoService storeInfoService;
    /**
     * 进入分类统计信息页面
     * @return
     */
    @GetMapping("/sort/info")
    public String getSortInfo(){
        return "sortInfo/info-sort";
    }

    /**
     * 景点分类统计信息
     * @return
     */
    @GetMapping("/sort/scenic")
    public String sortScenicInfo() {


        return "sortInfo/info-sort-scenic";
    }

    /**
     * 售票点分类统计信息
     * @return
     */
    @GetMapping("/sort/store")
    public String sortStoreInfo(@RequestParam(required = false,defaultValue = "1",name = "p")Integer pageNo,
                                @RequestParam(required = false,defaultValue = "")String storeName,
                                            Model model) {
        Map<String,String> searchParam = new HashMap<>();
        searchParam.put("storeName",storeName);
        PageInfo<TicketStore> pageInfo = storeInfoService.findAllTicketStore(1,searchParam);
        model.addAttribute("page",pageInfo);
        return "sortInfo/info-sort-store";
    }





}
