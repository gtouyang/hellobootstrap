package com.ogic.hellobootstrap.controller;

import com.ogic.hellobootstrap.dao.EmployeeDao;
import com.ogic.hellobootstrap.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String employeeList(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps", employees);

        return "emps/list";
    }
}
