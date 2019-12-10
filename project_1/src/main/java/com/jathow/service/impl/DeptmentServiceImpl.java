package com.jathow.service.impl;

import com.jathow.bean.Department;
import com.jathow.dao.IDepartmentDao;
import com.jathow.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptmentServiceImpl implements DepartmentService {

    @Autowired
    IDepartmentDao departmentDao;

    @Override
    public int deletDeptById(Integer deptId) {
        return departmentDao.deleteDeptById(deptId);
    }

    @Override
    public int updateDeptById(Integer deptId, Department department) {
        return departmentDao.updateDeptById(deptId, department);
    }

    @Override
    public int addDept(Department department) {
        return departmentDao.insertDept(department);
    }

    @Override
    public int getDeptCount() {
        return departmentDao.countDepts();
    }

    @Override
    public List<Department> getDeptList(Integer offset, Integer limit) {
        return departmentDao.selectDeptsByLimitAndOffset(offset, limit);
    }

    @Override
    public Department getDeptByName(String deptName) {
        return departmentDao.selectOneByName(deptName);
    }

    @Override
    public Department getDeptById(Integer deptId) {
        return departmentDao.selectOneById(deptId);
    }

    @Override
    public List<Department> getDeptName() {
        return departmentDao.selectDeptList();
    }
}
