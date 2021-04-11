package com.liuhao.bishe.service.Impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuhao.bishe.Mapper.EnvironmentMapper;
import com.liuhao.bishe.bean.Environment;
import com.liuhao.bishe.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnvironmentServiceImpl extends ServiceImpl<EnvironmentMapper,Environment> implements EnvironmentService{

    @Autowired
    EnvironmentMapper environmentMapper;
    @Override
    public Environment getNewData() {
        return environmentMapper.findNewData();
    }
}
