package com.zlz;


import com.zlz.filter.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class D_ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(D_ZuulApplication.class, args);
    }

    @Bean
    public AuthFilter accessFilter(){
        return new AuthFilter();
    }

}
