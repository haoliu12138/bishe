package com.liuhao.bishe.service;

import com.liuhao.bishe.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User findUser(String userName,String password);

    public int  addUser(String userName,String password);

    public int findUserByName(String userName);

    public void updatePassWordByName(String userName,String password);

}
