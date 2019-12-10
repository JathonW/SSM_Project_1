package com.jathow.test;

import com.jathow.bean.Department;
import com.jathow.dao.IDepartmentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class DepartmentDaoTest {

    @Autowired
    private IDepartmentDao departmentDao;

    @Test
    public void insertDeptTest(){
        Department department = new Department(null, "黎明3", "测试部");
        int res = departmentDao.insertDept(department);
        System.out.println(res);
    }

    @Test
    public void updateDeptTest(){
        Department department = new Department(null, "Tomsom", "研发部");
        int res = departmentDao.updateDeptById(1, department);
        System.out.println(res);
    }

    @Test
    public void deleteDeptTest(){
        int res = departmentDao.deleteDeptById(7);
        System.out.println(res);
    }

    @Test
    public void selectOneByIdTest(){
        Department department = departmentDao.selectOneById(1);
        System.out.println(department);
    }

    @Test
    public void selectOneByLeaderTest(){
        Department department = departmentDao.selectOneByLeader("马云");
        System.out.println(department);
    }

    @Test
    public void selectOneByNameTest(){
        Department department = departmentDao.selectOneByName("CEO");
        System.out.println(department);
    }

    @Test
    public void selectDeptListTest(){
        List<Department> departmentList = departmentDao.selectDeptList();
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println(departmentList.get(i));
        }
    }

    @Test
    public void selectDeptsByLimitAndOffsetTest(){
        List<Department> departments = departmentDao.selectDeptsByLimitAndOffset(2,5);
        System.out.println(departments.size());
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i));
        }
    }

    @Test
    public void countDeptsTest(){
        int count = departmentDao.countDepts();
        System.out.println(count);
    }
}
