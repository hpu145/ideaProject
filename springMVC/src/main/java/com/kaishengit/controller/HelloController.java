package com.kaishengit.controller;

import com.kaishengit.entity.User;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/2.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
    //使用该注解在-servlet.xml文件添加配置<mvc:annotation-driven/>
    @GetMapping("/send")
    public String send(Model model) {
        model.addAttribute("message","你好，MVC!");
        return "send";
    }
    /*@GetMapping("/send")
    public ModelAndView send() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("send");//设置视图的名字
        modelAndView.addObject("message","你好，世界!");
        return modelAndView;
    }*/

    @GetMapping("/blog")
    public String blog(Integer id,
                       @RequestParam(required = false,defaultValue = "1") Integer tagid, Model model) {
        System.out.println("id : " + id + " tagid : " + tagid);
        model.addAttribute("id",id);
        model.addAttribute("tagid",tagid);
        return "hello";
    }

    @GetMapping("/movie/{id:\\d+}")
    public String movie(@PathVariable Integer id) {
        System.out.println("movie id :" + id);
        return "hello";
    }

    @GetMapping("/class/{className}/user/{userid:\\d+}")
    public String user(@PathVariable String className,@PathVariable Integer userid) {
        System.out.println(className + "--->" +userid);
        return "hello";
    }

    @GetMapping("/save")
    public String save() {
        return "save";
    }
    @PostMapping("/save")
    public String save(User user, MultipartFile photo, RedirectAttributes redirectAttributes) {
        System.out.println(user.getUserName() + "--->" + user.getPassword());
        System.out.println("文件名称--》" + photo.getOriginalFilename());
        System.out.println("文件大小--》" + photo.getSize());
        System.out.println("MIMETYPE--》" + photo.getContentType());
        if(!photo.isEmpty()) {
            try {
                IOUtils.copy(photo.getInputStream(),
                        new FileOutputStream("d:/temp/" + photo.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message","资料审核中");
        return "redirect:/save";
    }

    @GetMapping("/user")
    @ResponseBody
    public User findById() {
        User user = new User();
        user.setId(100);
        user.setUserName("张雨");
        user.setPassword("123");
        return user;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> findAll() {
        User user = new User();
        user.setId(100);
        user.setUserName("张雨");
        user.setPassword("123");
        User user2 = new User();
        user2.setId(100);
        user2.setUserName("张雨");
        user2.setPassword("456");
        return Arrays.asList(user,user2);
    }

    @GetMapping("/session")
    public String show(HttpServletRequest request, HttpServletResponse response,
                       HttpSession session,@CookieValue("JSESSIONID")String sessionId) {
        session.setAttribute("hello","你好");
        System.out.println("SessionID -> " + sessionId);
        return "hello";
    }










}
