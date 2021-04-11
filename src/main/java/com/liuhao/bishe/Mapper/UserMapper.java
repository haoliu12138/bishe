package com.liuhao.bishe.Mapper;

import com.liuhao.bishe.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from user where userName=#{userName} and password=#{password}")
    public User findUserByALl(String userName,String password);

    @Insert("insert into user(userName,password) values(#{userName},#{password})")
    public int addUser(String userName,String password);

    @Select("select count(*) from user where userName=#{userName}")
    public int findUserById(String userName);

    @Update("update user set password=#{password} where userName=#{username}")
    public int updateUserByUsername(String username,String password);

}
