package com.ogic.hellobootstrap.controller;

import com.ogic.hellobootstrap.dao.DepartmentDao;
import com.ogic.hellobootstrap.dao.EmployeeDao;
import com.ogic.hellobootstrap.entities.Department;
import com.ogic.hellobootstrap.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emp")
    public String employeeList(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps", employees);

        return "emp/list";
    }

    @GetMapping("/add-emp")
    public String toAddEmployeePage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/add-emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emp";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        Employee employee =  employeeDao.get(id);
        model.addAttribute("emp",employee);
        return "emp/add";
    }

    @PutMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Employee employee){
        employee.setId(id);
        employeeDao.save(employee);
        return "redirect:/emp";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emp";
    }
}
