package com.kaishengit.service;

import com.kaishengit.entity.Dept;
import com.kaishengit.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/6.
 */
public interface AdminService {

    String login(HttpServletRequest request,String email, String password);

    void save(String employeeName,String mobile,String password);

    List<Employee> findEmployeeList();



}
