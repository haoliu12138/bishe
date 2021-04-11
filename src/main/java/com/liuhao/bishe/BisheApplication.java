package com.liuhao.bishe;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
// 是否开启定时任务调度功能
@EnableScheduling

public class BisheApplication {
    public static void main(String[] args) {
        SpringApplication.run(BisheApplication.class, args);
    }

}
