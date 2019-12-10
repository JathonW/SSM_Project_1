package com.jathow.controller;

import com.jathow.bean.Employee;
import com.jathow.service.EmployeeService;
import com.jathow.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jathow/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 查询数据所占页数
     * @param pageNo
     * @return
     */
    @GetMapping(value = "/getEmpList")
    public ModelAndView getEmp(@RequestParam(value = "pageNo", defaultValue = "1")
                                           Integer pageNo){
        ModelAndView mv = new ModelAndView("employeePage");
        int limit = 5;

        int offset = (pageNo-1)*limit;

        List<Employee> employees = employeeService.getEmpList(offset,limit);

        int totalItems = employeeService.getEmpCount();

        int temp = totalItems / limit;
        int totalPages = (totalItems % limit == 0) ? temp : temp + 1;

        int curPage = pageNo;

        mv.addObject("employees", employees)
                .addObject("totalItems",totalItems)
                .addObject("totalPages",totalPages)
                .addObject("curPage",curPage);
        return mv;
    }

    /**
     * 查询员工姓名是否符合规范，是否存在重名信息
     * @param empName
     * @return
     */
    @GetMapping("/checkEmpExists")
    @ResponseBody
    public JsonMsg checkEmpExists(@RequestParam("empName") String empName){
        String regName = "(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        //判断是否符合通识符
        if(!empName.matches(regName)){
            return  JsonMsg.fail().addInfo("name_reg_error",
                    "输入姓名为2-5位中文或6-16位英文和数字组合");
        }
        Employee employee = employeeService.getEmpByName(empName);
        if(employee != null){
            return JsonMsg.fail().addInfo("name_reg_error","用户名重复");
        } else {
            return JsonMsg.success();
        }
    }

    /**
     * 执行其他操作后 查询总页数
     * @return
     */
    @GetMapping("/getTotalPages")
    @ResponseBody
    public JsonMsg getTotalPage(){
        int totalItems = employeeService.getEmpCount();

        int temp = totalItems / 5;
        int totalPages = (totalItems % 5 == 0) ? temp : temp + 1;

        return JsonMsg.success().addInfo("totalPages",totalPages);
    }

    /**
     * 添加新员工
     * @param employee
     * @return
     */
    @PostMapping("/addEmp")
    @ResponseBody
    public JsonMsg addEmp(Employee employee){
        int res = employeeService.addEmp(employee);
        if (res == 1){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }

    /**
     * 根据ID更改员工信息
     * @param empId
     * @param employee
     * @return
     */
    @PutMapping("/updateEmp/{empId}")
    @ResponseBody
    public JsonMsg updateEmp(@PathVariable("empId") Integer empId, Employee employee){
        int res = employeeService.updateEmpById(empId, employee);
        if (res != 1){
            return JsonMsg.fail().addInfo("emp_update_error","更改异常");
        }
        return JsonMsg.success();
    }

    @DeleteMapping("/deleteEmp/{empId}")
    @ResponseBody
    public JsonMsg deleteEmp(@PathVariable("empId") Integer empId){
        int res = employeeService.deleteEmpById(empId);
        if (res != 1){
            return JsonMsg.fail().addInfo("emp_del_error","员工删除异常");
        }
        return JsonMsg.success();
    }

}
