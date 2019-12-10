package com.jathow.controller;

import com.jathow.util.JsonMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/jathow")
public class LoginController {

    /**
     * 登录：跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 对登录界面的简单判断
     * @param request
     * @return
     */
    @PostMapping("/dologin")
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);
        if(!"admin1234".equals(username+password)){
            return JsonMsg.fail().addInfo("login_error","输入账号用户名与密码不匹配，请重新输入！");
        }
        return JsonMsg.success();
    }

    /**
     * 跳转主页面
     * @return
     */
    @GetMapping("/main")
    public String main(){
        return "main";
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

}
