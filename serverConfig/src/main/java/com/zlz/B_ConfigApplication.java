package com.zlz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
//@EnableEurekaClient 2.0已经不需要此注解来开启服务注册与发现功能了，引用了cleint就带有此功能了
public class B_ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(B_ConfigApplication.class, args);
    }
}
