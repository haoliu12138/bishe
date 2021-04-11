package com.liuhao.bishe.service.Impl;

import com.liuhao.bishe.Mapper.UserMapper;
import com.liuhao.bishe.bean.User;
import com.liuhao.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserMapper userMapper;
    @Override
    public User findUser(String userName,String password) {
        return userMapper.findUserByALl(userName,password);
    }

    @Override
    public int addUser(String userName, String password) {
        userMapper.addUser(userName, password);
        return 0;
    }

    @Override
    public int findUserByName(String userName) {
        return userMapper.findUserById(userName);
    }

    @Override
    public void updatePassWordByName(String userName,String password) {
        userMapper.updateUserByUsername(userName,password);
    }
}
