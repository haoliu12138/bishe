package com.liuhao.bishe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuhao.bishe.Mapper.EnvironmentMapper;
import com.liuhao.bishe.bean.Environment;
import com.liuhao.bishe.bean.User;
import com.liuhao.bishe.service.EnvironmentService;
import com.liuhao.bishe.service.Impl.EnvironmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DateController {
    @Autowired
    EnvironmentServiceImpl environmentService;
    //接收ajax请求返回最新数据
    @RequestMapping(value="/getHum",method= RequestMethod.POST)
    @ResponseBody
    public Environment gethum()
    {
        try {
            Environment e = new Environment();
            e=environmentService.getNewData();
            return e;
        }catch (Exception e){
            return null;
        }finally {

        }

    }
//    @GetMapping("/allDataTable")
//    public String getAllDataT(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model)
//    {
//
//
//        Page<Environment> page = new Page<>(pn, 2);
//        //调用page进行分页
//        Page<Environment> environmentPage =environmentService.page(page,null);
//
////        i=environmentPage.getRecords();
////        j=environmentPage.getCurrent();;
////        k=environmentPage.getPages();
//
//
//        model.addAttribute("environments",environmentPage);
//
//        return "tables/allDataTablePage";
//    }
}
