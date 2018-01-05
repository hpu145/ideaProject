package com.kaishengit.service.impl;


import com.kaishengit.entity.Admin;
import com.kaishengit.entity.AdminExample;
import com.kaishengit.entity.Dept;
import com.kaishengit.entity.Employee;
import com.kaishengit.mapper.AdminMapper;
import com.kaishengit.mapper.DeptMapper;
import com.kaishengit.mapper.EmployeeMapper;
import com.kaishengit.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by zhangyu on 2017/11/6.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public String login(HttpServletRequest request,String email, String password) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andEmailEqualTo(email);
        Admin admin = adminMapper.findByEmail(email);
        String salt = "%$%$1234asdaDFG%%^@#SDF#$#%";
        String newPassword = DigestUtils.md5Hex(password + salt);
        if (admin !=null && newPassword.equals(admin.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("curr_admin",admin);
            return "employee";
        }
        return "login";
    }

    @Override
    public void save(String employeeName,String mobile, String password) {
        employeeMapper.save(employeeName,mobile,password);
    }

    @Override
    public List<Employee> findEmployeeList() {
        return employeeMapper.findAllEmployee();
    }





}
