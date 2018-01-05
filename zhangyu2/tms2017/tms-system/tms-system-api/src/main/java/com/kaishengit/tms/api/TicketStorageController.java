package com.kaishengit.tms.api;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.api.result.AjaxResult;
import com.kaishengit.tms.entity.Ticket;
import com.kaishengit.tms.entity.TicketStore;
import com.kaishengit.tms.service.TicketStorageService;
import com.kaishengit.tms.service.exception.ServiceException;
import com.kaishengit.tms.system.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 年票库存管理
 */
@Controller
public class TicketStorageController {

    @Autowired
    private TicketStorageService ticketStorageService;
    @Autowired
    private StoreInfoService storeInfoService;

    /**
     * 年票入库
     * @return
     */
    @GetMapping("/ticket/in")
    public String ticketIn(Model model) {
        //从数据库中查出id最大的ticket
        Ticket ticket = ticketStorageService.findMaxIdTicket();
        model.addAttribute("ticketIdMax",ticket);
        return "storage/ticket-in";
    }
    @PostMapping("/ticket/in")
    public String ticketIn(RedirectAttributes attributes,String ticketNumStart,String ticketInTotal,
                           Integer ticketNumEnd, String ticketInTime, String invalidNum) {

        ticketStorageService.inStorage(ticketNumStart,ticketNumEnd,ticketInTime,invalidNum,ticketInTotal);
        attributes.addFlashAttribute("message","年票入库成功！");
        return "redirect:/ticket/in";
    }

    /**
     * 年票下发
     * @return
     */
    @GetMapping("/ticket/out")
    public String ticketOut(Model model) {
        PageInfo<TicketStore> pageInfo = storeInfoService.findAllTicketStore(1,null);
        //查找当前数据库中已下发的最小编号
        Ticket ticket = ticketStorageService.findTicketOutWithIdMin();
        model.addAttribute("ticketOutWithIdMin",ticket);
        model.addAttribute("page",pageInfo);
        return "storage/ticket-out";
    }
    @PostMapping("/ticket/out")
    public String ticketOut(RedirectAttributes attributes, String ticketNumStart, Integer ticketNumEnd,
                            Integer storeAccountId,String ticketOutTotal) {
        try {
            ticketStorageService.outStorage(ticketNumStart,ticketNumEnd,storeAccountId,ticketOutTotal);
        } catch (NullPointerException ex) {
            attributes.addFlashAttribute("message",ex.getMessage());
            return "redirect:/ticket/out";
        }
        attributes.addFlashAttribute("message","年票下发成功！");
        return "redirect:/ticket/out";
    }


    /**
     * 年票作废
     * @return
     */
    @GetMapping("/ticket/invalid")
    public String invalidTicket(Model model) {
        PageInfo<TicketStore> pageInfo = storeInfoService.findAllTicketStore(1,null);
        model.addAttribute("page",pageInfo);
        return "storage/ticket-invalid";
    }
    @PostMapping("/ticket/invalid")
    public String invalidTicket(RedirectAttributes redirectAttributes,
                                Integer storeAccountId,String invalidNum) {
        try {
            ticketStorageService.invalidTicket(storeAccountId,invalidNum);
            redirectAttributes.addFlashAttribute("message","年票已成功作废!");
            return "redirect:/ticket/invalid";
        } catch (ServiceException ex) {
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            return "redirect:/ticket/invalid";
        }
    }

    /**
     * 盘点统计
     * @return
     */
    @GetMapping("/ticket/total")
    public String ticketTotally() {
        return "storage/ticket-total";
    }
    @GetMapping("/ticket/total/chart")
    @ResponseBody
    public AjaxResult ticketTotal( ) {
        Long ticketIn = ticketStorageService.findTotalTicketIn();
        Long ticketOut = ticketStorageService.findTotalTicketOut();
        Long ticketInvalid = ticketStorageService.findTotalInvalidTicket();
        Long ticketStorage = ticketStorageService.findTicketStorage();

        Map<String,Object> map = new HashMap<>();
        map.put("入库数量",ticketIn);
        map.put("下发数量",ticketOut);
        map.put("作废数量",ticketInvalid);
        map.put("库存量",ticketStorage);

        List<Map<String,Object>> result = new ArrayList<>();
        result.add(map);
        System.out.println(result.size());
        return AjaxResult.successWithData(result);
    }

    /**
     * 售票点信息统计
     * @return
     */
    @GetMapping("/ticket/total/shore")
    public String storeTicketTotal(Model model) {
        return "storage/ticket-store-total";
    }











}
