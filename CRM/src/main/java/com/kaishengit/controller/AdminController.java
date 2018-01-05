package com.kaishengit.controller;


import com.kaishengit.entity.Admin;
import com.kaishengit.entity.Dept;
import com.kaishengit.entity.Employee;
import com.kaishengit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/6.
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String login(Admin admin, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String path =  adminService.login(request,admin.getEmail(),admin.getPassword());
        redirectAttributes.addFlashAttribute("error","您的账户或密码错误");
        return "redirect:/"+path+"";
    }
    @GetMapping("/employee")
    public String employee(Model model) {
        List<Employee> employeeList = adminService.findEmployeeList();
        model.addAttribute("employeeList",employeeList);
        return "employee";
    }

    @GetMapping("/employee_new")
    public String employeeNew(Model model) {
        return "employee-new";
    }

    @PostMapping("/employee_new")
    public String employeeNew(Employee employee,RedirectAttributes redirectAttributes) {
        adminService.save(employee.getEmployeeName(),employee.getMobile(),employee.getPassword());
        redirectAttributes.addFlashAttribute("message","新增成功");
        return "redirect:/employee";
    }







}
