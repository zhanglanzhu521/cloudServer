package com.zlz;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix//断路器
@EnableHystrixDashboard//在ribbon中使用hystrix dashboard(仪表盘)功能
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }



    @Bean
    @LoadBalanced//负载均衡机制
    public RestTemplate restTemplate(){//调用模板
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloError")//断路器熔断机制
    public String hello(String name){
        String result=restTemplate.getForObject("http://HelloServer/hello?name="+name,String.class);
        return result;

    }


    /**
     * 熔断方法
     * @param name
     * @return
     */
    public String helloError(String name){
        return "hello  ,"+name+"!  sorry ,error !";
    }
}
