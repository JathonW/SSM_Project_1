package com.jathow.service;

import com.jathow.bean.Department;

import java.util.List;

public interface DepartmentService {

    public int deletDeptById(Integer deptId);

    public int updateDeptById(Integer deptId, Department department);

    public int addDept(Department department);

    public int getDeptCount();

    public List<Department> getDeptList(Integer offset, Integer limit);

    public Department getDeptByName(String deptName);

    public Department getDeptById(Integer deptId);

    public List<Department> getDeptName();
}
