package com.hz.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration //表示这是一个配置类
public class AlphaConfig {

    @Bean //定义第三方的bean   bean的名字就是方法名   返回的对象将被装配到容器里
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }


}
