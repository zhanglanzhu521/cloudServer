package com.zlz;


import com.zlz.common.config.ApplicationContextInitializerTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class A_EurekaApplication {
    public static void main(String[] args) {
//        SpringApplication.run(A_EurekaApplication.class, args);

        SpringApplication springApplication = new SpringApplication(A_EurekaApplication.class);

        //添加自己初始化的实例
        springApplication.addInitializers(new ApplicationContextInitializerTest());

        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
    }
}
