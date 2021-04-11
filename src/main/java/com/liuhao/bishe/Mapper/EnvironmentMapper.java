package com.liuhao.bishe.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuhao.bishe.bean.Environment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface EnvironmentMapper extends BaseMapper<Environment> {
    @Insert("insert into environment(light,humidity,temperature,voc,humid,date) values(#{light},#{hum},#{temp},#{voc},#{humid},#{date})")
    public int addData(int light, int hum, int temp, int voc, int humid, Date date);
    @Select("select * from environment order by id desc limit 1")
    public Environment findNewData();
    @Select("select * from environment order by id  limit 500")
    public List<Environment> findOTData();
}
