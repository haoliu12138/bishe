package com.liuhao.bishe;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuhao.bishe.Mapper.EnvironmentMapper;
import com.liuhao.bishe.Mapper.UserMapper;
//import com.liuhao.bishe.bean.StuEntity;
import com.liuhao.bishe.bean.Environment;
import com.liuhao.bishe.provider.Provider;
import com.liuhao.bishe.service.EnvironmentService;
import com.liuhao.bishe.service.Impl.EnvironmentServiceImpl;
import com.liuhao.bishe.service.Impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@SpringBootTest
class BisheApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    EnvironmentMapper environmentMapper;
    @Autowired
    EnvironmentServiceImpl environmentService;
    @Autowired
    Provider provider;
    @Test
    void contextLoads()
    {
        environmentMapper.addData(10,10,10,10,10,new Date());
        System.out.println(new Date());
    }
    @Test
    void sqltest()
    {
        log.info("插入结果{}",environmentMapper.selectList(null).size());
    }


    @Test
    public void addenvironment()
    {
        environmentMapper.addData(10,10,10,10,10,new Date());
    }
    @Test void selectData()
    {
        List<Environment> environments=environmentMapper.findOTData();
        for(int i=0;i<500;i++)
        {
            System.out.println(environments.get(i));
        }
    }
    @Test void updateTest()
    {
        log.info("修改结果{}",userMapper.updateUserByUsername("admin","admin"));
    }
    @Test
    public void publish()
    {
        provider.produceTopic("LED_OFF");

    }

}
