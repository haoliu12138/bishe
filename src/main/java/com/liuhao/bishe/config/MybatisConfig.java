package com.liuhao.bishe.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
    @Bean
    public MybatisPlusInterceptor paginationInterceptor()
    {
        MybatisPlusInterceptor mybatisPlusInterceptor=new MybatisPlusInterceptor();

        //设置最大单页限制数量，默认500条，-1不受限制。

        PaginationInnerInterceptor paginationInnerInterceptor=new PaginationInnerInterceptor();
        //设置请求的页面大于最大页后操作，true回到首页，false继续请求，默认false.
        paginationInnerInterceptor.setOverflow(true);
        //设置最大单页限制数量，默认500条，-1不受限制。
        paginationInnerInterceptor.setMaxLimit(500L);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);

        return mybatisPlusInterceptor;

    }
}
