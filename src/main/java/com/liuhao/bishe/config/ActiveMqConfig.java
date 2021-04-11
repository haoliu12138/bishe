package com.liuhao.bishe.config;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;
import javax.jms.Topic;
// 让spring管理的注解，相当于spring中在xml 中写了个bean
@Component
// 开启jms适配
@EnableJms

public class ActiveMqConfig {
    // 注入配置文件中的 myqueue
    @Value("${mytopic}")
    private String topicName ;

    @Bean   // bean id=""  class="…"
    public Topic topic(){
        return  new ActiveMQTopic(topicName);
    }

}
