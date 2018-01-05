package com.kaishengit.tms.api;


import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.TicketStore;
import com.kaishengit.tms.system.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 售票点信息控制器
 */
@Controller
public class StoreInfoController {

    @Autowired
    private StoreInfoService storeInfoService;

    /**
     * 获取售票点信息
     * @return
     */
    @GetMapping("/store/info")
    public String getStoreInfo(Model model) {
        PageInfo<TicketStore> pageInfo = storeInfoService.findAllTicketStore(1,null);
        model.addAttribute("page",pageInfo);
        return "storeInfo/info-store";
    }

    /**
     * 根据id查找售票点信息
     * @return
     */
    @GetMapping("/store/{id:\\d+}")
    public String showStoreDetail(@PathVariable Integer id,Model model) {
        TicketStore ticketStore = storeInfoService.findTicketStoreById(id);
        model.addAttribute("store",ticketStore);
        return "storeInfo/info-store-detail";
    }

    /**
     * 添加售票点
     * @return
     */
    @GetMapping("/store/new")
    public String newStore() {
        return "storeInfo/info-store-new";
    }




}
