package com.liuhao.bishe.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    @Excel(name = "光照强度(lux)")
    private int light;
    @Excel(name="湿度(%rh)")
    private int humidity;
    @Excel(name = "温度(℃)")
    private int temperature;
    @Excel(name = "空气有害物质浓度(mg/m3)")
    private int voc;
    @Excel(name = "紫外线等级(0-11)")
    private int humid;
    @Excel(name = "采集日期")
    private String date;
}
