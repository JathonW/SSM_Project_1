package com.jathow.service;

import com.jathow.bean.Employee;
import com.jathow.dao.IEmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


public interface EmployeeService {

    public int getEmpCount();

    public List<Employee> getEmpList(Integer offser, Integer limit);

    public Employee getEmpById(Integer empId);

    public Employee getEmpByName(String empName);

    public int updateEmpById(Integer empId, Employee employee);

    public int deleteEmpById(Integer empId);

    public int addEmp(Employee employee);
}
