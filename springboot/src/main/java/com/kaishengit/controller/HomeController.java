package com.kaishengit.controller;

import com.kaishengit.entity.User;
import com.kaishengit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangyu on 2017/12/7.
 */
@Controller
public class HomeController {


    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String home(Model model, HttpSession session) {
        //User user = new User(001,"jack",28);
        //model.addAttribute("user",user);
        session.setAttribute("curr_user","user001");
        model.addAttribute("message","Message of SpringBoot");
        model.addAttribute("datetime",new Date());
        List<String> nameLists = Arrays.asList("AA","BB","CC");
        model.addAttribute("namelists",nameLists);
        return "hello";
    }


    @GetMapping("/save")
    public String save(String userName,String passWard) {
        userName = "zhangyu";
        passWard = "123";
        userService.save(userName,passWard);
        return "redirect:/hello";
    }

    @GetMapping("/saveuser")
    public String save(User user) {
        user = new User();
        user.setUserName("jack");
        user.setPassWard("123");

        userService.saveuser(user);
        return "redirect:/hello";
    }



}
