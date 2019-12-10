package com.jathow.service.impl;

import com.jathow.bean.Employee;
import com.jathow.dao.IEmployeeDao;
import com.jathow.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    IEmployeeDao employeeDao;

    @Override
    public int getEmpCount() {
        return employeeDao.countEmps();
    }

    @Override
    public List<Employee> getEmpList(Integer offser, Integer limit) {
        return employeeDao.selectByLimitAndOffset(offser, limit);
    }

    @Override
    public Employee getEmpById(Integer empId) {
        return employeeDao.selectOneById(empId);
    }

    @Override
    public Employee getEmpByName(String empName) {
        return employeeDao.selectOneByName(empName);
    }

    @Override
    public int updateEmpById(Integer empId, Employee employee) {
        return employeeDao.updateOneById(empId, employee);
    }

    @Override
    public int deleteEmpById(Integer empId) {
        return employeeDao.deleteOneById(empId);
    }

    @Override
    public int addEmp(Employee employee) {
        return employeeDao.insertOne(employee);
    }
}

