package com.liuhao.bishe.consumer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liuhao.bishe.Mapper.EnvironmentMapper;
import com.liuhao.bishe.bean.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.BytesMessage;
import javax.jms.TextMessage;
import java.util.Date;

@Component
public class Consumer {
    @Autowired
    EnvironmentMapper environmentMapper;
    @JmsListener(destination = "${hum}")
    public void receive(BytesMessage bytesMessage) throws  Exception{
        int i;
        //接收数据缓冲区
        byte[] bytes=new byte[100];
        //读取接收到的字节消息到变量
        bytesMessage.readBytes(bytes);
        //吧字节消息变成字符串
        String s=new String(bytes,"ascii");
        //System.out.println(s);
        //把字符串转换为数据对象转换时不区分大小写但是json格式键的英文拼写要和类中的成员变量名一致
        Environment e=JSON.parseObject(s,Environment.class);
        //System.out.println("Light:"+e.getLight()+" Temperature:"+e.getTemperature()+" humidity:"+e.getHumidity()+" voc:"+e.getVoc()+" humid:"+e.getHumid());
        //把数据对象保存到数据库
        environmentMapper.addData(e.getLight(),e.getHumidity(),e.getTemperature(),e.getVoc(),e.getHumid(),new Date());
    }

}
