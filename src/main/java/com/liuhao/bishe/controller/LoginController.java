package com.liuhao.bishe.controller;

import com.liuhao.bishe.bean.User;
import com.liuhao.bishe.provider.Provider;
import com.liuhao.bishe.service.Impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;
    //此类中有自动注入属性，用new 来创建会失败。
    @Autowired
    Provider provider;
    //访问/login或者直接访问项目路径且请求方式为get方式返回登录页面
    @GetMapping(value={"/login","/"})
    public String login()
    {
        return "loginPage";
    }
    //以post方式请求login为登录，登陆成功到主页不成功则返回登录页
    @PostMapping("/main.html")
    public String getUser(User user, HttpSession httpSession,Model model)
    {
        if(userService.findUser(user.userName,user.password)!=null)
        {
            //将User对象存到Session域中
            httpSession.setAttribute("loginUser",new User(user.userName,user.password));
            //请求重定向放置表单重复提交
            return  "redirect:/main";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "loginPage";
    }
    //返回主页面
    @GetMapping("/main")
    public String main()
    {
        return "mainPage";
    }
    //去注册按钮
    @GetMapping(value = "/registerBtn")
    public String regiestBtn()
    {
        return "registration";
    }
    //确认注册按钮
    @PostMapping("/register")
    public String register(@RequestParam("userName")    String userName,
                           @RequestParam("password")    String password,
                           Model model)
    {
        //用户不存在则插入用户，否则返回注册页
        if (userService.findUserByName(userName) == 0)
        {
            userService.addUser(userName, password);
            return "redirect:/login";
        }
        else
        {
            model.addAttribute("remsg","用户名已存在");
            return "registration";
        }

    }
    @GetMapping("/chart")
    public String chart()
    {
        provider.produceTopic("");
        return "redirect:/login";
    }
    @PostMapping("/updateUserNAP")
    public String updateUser(   @RequestParam("username") String username,
                                @RequestParam("pwd") String pwd,
                                Model model)
    {
        userService.updatePassWordByName(username,pwd);
        return "redirect:/login";
    }


}
