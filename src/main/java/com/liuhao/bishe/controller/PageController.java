package com.liuhao.bishe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuhao.bishe.bean.Environment;
import com.liuhao.bishe.service.Impl.EnvironmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    EnvironmentServiceImpl environmentService;
    @GetMapping("/humidityChart")
    public String getHumidityPage()
    {
        return "/chart/humidity";
    }
    @GetMapping("/lightChart")
    public String getLight()
    {
        return "/chart/light";
    }
    @GetMapping("/vocChart")
    public String getVoc()
    {
        return "/chart/voc";
    }
    @GetMapping("/humid")
    public String getHumid()
    {
        return "/chart/humid";
    }
    @GetMapping("/allData")
    public String getAllData(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

//        List<Environment> i = environmentPage.getRecords();
//        Long j=environmentPage.getCurrent();;
//        Long k=environmentPage.getPages();


        model.addAttribute("environments",environmentPage);
        return "/tables/allDataTablePage";
    }
    @GetMapping("/humidityData")
    public String getHumidityData(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

//        List<Environment> i = environmentPage.getRecords();
//        Long j=environmentPage.getCurrent();;
//        Long k=environmentPage.getPages();


        model.addAttribute("environments",environmentPage);
        return "/tables/humidityDataTable";
    }
    @GetMapping("/temperatureData")
    public String getTemperatureData(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

//        List<Environment> i = environmentPage.getRecords();
//        Long j=environmentPage.getCurrent();;
//        Long k=environmentPage.getPages();


        model.addAttribute("environments",environmentPage);
        return "/tables/temperatureDataTable";
    }
    @GetMapping("/lightData")
    public String getLightData(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

//        List<Environment> i = environmentPage.getRecords();
//        Long j=environmentPage.getCurrent();;
//        Long k=environmentPage.getPages();


        model.addAttribute("environments",environmentPage);
        return "/tables/lightDataTable";
    }
    @GetMapping("/vocData")
    public String getVocData(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

//        List<Environment> i = environmentPage.getRecords();
//        Long j=environmentPage.getCurrent();;
//        Long k=environmentPage.getPages();


        model.addAttribute("environments",environmentPage);
        return "/tables/vocDataTable";
    }
    @GetMapping("/humidData")
    public String getHumidData(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

//        List<Environment> i = environmentPage.getRecords();
//        Long j=environmentPage.getCurrent();;
//        Long k=environmentPage.getPages();


        model.addAttribute("environments",environmentPage);
        return "/tables/humidDataTable";
    }

    @GetMapping("/updateUser")
    public String getHumidData()
    {

        return "updateUser";
    }

    @GetMapping("ledControlPage")
    public String ledControlPage()
    {
        return "control/ledControl";
    }


}
