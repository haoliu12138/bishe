package com.liuhao.bishe.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuhao.bishe.bean.Environment;
import com.liuhao.bishe.bean.User;


public interface EnvironmentService extends IService<Environment>{

    public Environment getNewData();

}
