package com.liuhao.bishe.controller;

import com.liuhao.bishe.provider.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SwitchController {
    @Autowired
    Provider provider;
    @GetMapping("/lightSwitch")
    public String lightSwitch(@RequestParam("state") String state, HttpSession httpSession)
    {
        provider.produceTopic(state);
        if(state.equals("LED_ON"))
        {
            httpSession.setAttribute("state","灯光开启状态");
        }else
        {
            httpSession.setAttribute("state","灯光关闭状态");
        }
        return "redirect:/ledControlPage";

    }
}
