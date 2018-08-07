package com.zlz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@EnableHystrixDashboard//hystrix dashboard(仪表盘)功能
@EnableCircuitBreaker//hystrix dashboard(仪表盘)功能
public class C_FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(C_FeignApplication.class, args);
    }

    //springCloud config 拉取内容 测试 str
//      @Value("${content}")
//      String content;


    @Value("${name}")
    private  String name;
    @Value("${age}")
    private  String age;
    @Value("${version}")
    private  String version="开发环境";

    @Value("${level}")
    private String level;

    @RequestMapping("/test")
    public String test(){
        return "你好，我是"+name+",年龄："+age+"岁。当前环境："+version+"level:"+level;
    }
    //springCloud config 拉取内容 测试 end


    //@FeignClient("HelloServer")//服务名称 spring.application.name=HelloServer
    @FeignClient(value = "HelloServer" ,fallback = HelloError.class)//熔断器参数
    public interface HelloService {
        @RequestMapping(value = "/hello", method = RequestMethod.GET)
        public String hello(@RequestParam("name") String name);



    }

    @Component
    public class HelloError implements HelloService {//熔断器实现,实现其方法
        @Override
        public String hello(String name){
            return "hello  ,"+name+"!  sorry ,error !";
        }
    }

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(@RequestParam("name")String name){
        //结合cloud config 返回调用方拉取的数据内容,测试是否拉取成功
        String msg= "你好，我是"+name+",年龄："+age+"岁。当前环境："+version+"level:"+level;
        return helloService.hello(msg);
    }




}
