package com.liuhao.bishe.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuhao.bishe.bean.Environment;
import com.liuhao.bishe.service.Impl.EnvironmentServiceImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExcelDownload {
    @Autowired
    EnvironmentServiceImpl environmentService;
    //下载所有数据
    @RequestMapping("/downloadAllData")
    @ResponseBody
    public String download(HttpServletResponse response,
                         @RequestParam(value = "pn",defaultValue = "1") Integer pn)
    {
//        List<StuEntity> list=new ArrayList<>();
//        list.add(new StuEntity("刘浩","123","男"));
//        list.add(new StuEntity("浩哥","123","女"));
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
//                StuEntity.class, list);
//
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("content-Type", "application/vnd.ms-excel");
//        try {
//            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("test.xls", "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        try {
//            workbook.write(response.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

        List<Environment> environments=environmentPage.getRecords();

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("所有环境信息表","所有环境信息表"),
                Environment.class, environments);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("第"+pn+"页所有数据.xls", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/allData?pn="+pn;

    }
    @RequestMapping("/downloadHumidData")
    @ResponseBody
    public String downloadHumidData(HttpServletResponse response,
                                    @RequestParam(value = "pn",defaultValue = "1") Integer pn)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

        List<Environment> environments=environmentPage.getRecords();

        List<ExcelExportEntity> entity=new ArrayList<ExcelExportEntity>();

        ExcelExportEntity humid=new ExcelExportEntity("紫外线等级(1-11)","humid");

        ExcelExportEntity date=new ExcelExportEntity("采集日期","date");

        entity.add(humid);
        entity.add(date);
        List list=new ArrayList();
        for(int i=0;i<environments.size();i++)
        {
            Map map=new HashMap();
            map.put("humid",environments.get(i).getHumid());
            map.put("date",environments.get(i).getDate());
            list.add(map);
        }



        Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("第"+pn+"页紫外线等级数据","第"+pn+"页紫外线等级数据"),entity,list);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("第"+pn+"页紫外线等级数据.xls", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/humidData?pn="+pn;
    }
    @RequestMapping("/downloadHumidity")
    @ResponseBody
    public String downloadHumidity(HttpServletResponse response,
                                   @RequestParam(value = "pn",defaultValue = "1") Integer pn)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

        List<Environment> environments=environmentPage.getRecords();

        List<ExcelExportEntity> entity=new ArrayList<ExcelExportEntity>();

        ExcelExportEntity humidity=new ExcelExportEntity("湿度(%rh)","humidity");

        ExcelExportEntity date=new ExcelExportEntity("采集日期","date");

        entity.add(humidity);
        entity.add(date);
        List list=new ArrayList();
        for(int i=0;i<environments.size();i++)
        {
            Map map=new HashMap();
            map.put("humidity",environments.get(i).getHumidity());
            map.put("date",environments.get(i).getDate());
            list.add(map);
        }



        Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("第"+pn+"页湿度数据","第"+pn+"页湿度数据"),entity,list);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("第"+pn+"页湿度数据.xls", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/humidityData?pn="+pn;

    }
    @RequestMapping("/downloadLight")
    @ResponseBody
    public String downloadLight(HttpServletResponse response,
                                   @RequestParam(value = "pn",defaultValue = "1") Integer pn)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

        List<Environment> environments=environmentPage.getRecords();

        List<ExcelExportEntity> entity=new ArrayList<ExcelExportEntity>();

        ExcelExportEntity light=new ExcelExportEntity("光照强度(lux)","light");

        ExcelExportEntity date=new ExcelExportEntity("采集日期","date");

        entity.add(light);
        entity.add(date);
        List list=new ArrayList();
        for(int i=0;i<environments.size();i++)
        {
            Map map=new HashMap();
            map.put("light",environments.get(i).getLight());
            map.put("date",environments.get(i).getDate());
            list.add(map);
        }



        Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("第"+pn+"页光照强度数据","第"+pn+"页光照强度数据"),entity,list);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("第"+pn+"页光照强度数据.xls", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/lightData?pn="+pn;

    }
    @RequestMapping("/downloadTemperature")
    @ResponseBody
    public String downloadTemperature(HttpServletResponse response,
                                @RequestParam(value = "pn",defaultValue = "1") Integer pn)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

        List<Environment> environments=environmentPage.getRecords();

        List<ExcelExportEntity> entity=new ArrayList<ExcelExportEntity>();

        ExcelExportEntity temperature=new ExcelExportEntity("温度(温度(℃))","temperature");

        ExcelExportEntity date=new ExcelExportEntity("采集日期","date");

        entity.add(temperature);
        entity.add(date);
        List list=new ArrayList();
        for(int i=0;i<environments.size();i++)
        {
            Map map=new HashMap();
            map.put("temperature",environments.get(i).getTemperature());
            map.put("date",environments.get(i).getDate());
            list.add(map);
        }



        Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("第"+pn+"页温度数据","第"+pn+"页温度数据"),entity,list);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("第"+pn+"页温度数据.xls", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/temperatureData?pn="+pn;

    }
    @RequestMapping("/downloadVoc")
    @ResponseBody
    public String downloadVoc(HttpServletResponse response,
                                      @RequestParam(value = "pn",defaultValue = "1") Integer pn)
    {
        Page<Environment> page = new Page<>(pn, 100);
        //调用page进行分页
        Page<Environment> environmentPage =environmentService.page(page,null);

        List<Environment> environments=environmentPage.getRecords();

        List<ExcelExportEntity> entity=new ArrayList<ExcelExportEntity>();

        ExcelExportEntity voc=new ExcelExportEntity("空气有害物质浓度(mg/m3)","voc");

        ExcelExportEntity date=new ExcelExportEntity("采集日期","date");

        entity.add(voc);
        entity.add(date);
        List list=new ArrayList();
        for(int i=0;i<environments.size();i++)
        {
            Map map=new HashMap();
            map.put("voc",environments.get(i).getVoc());
            map.put("date",environments.get(i).getDate());
            list.add(map);
        }



        Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("第"+pn+"页空气质量数据","第"+pn+"页空气质量数据"),entity,list);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("第"+pn+"页空气质量数据.xls", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/vocData?pn="+pn;

    }
}
