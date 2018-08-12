package com.db.dynamicdatasource.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @Title :拦截请求打印日志AOP
 * @Description :拦截请求打印日志AOP
 * @Author : zhanglz
 * @Date : 2018/8/12
 */
@Aspect
@Component
public class HttpLog {

    public static final Logger logger = LoggerFactory.getLogger(HttpLog.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.db.dynamicdatasource.controller.*.*(..))")
    public void httpLog() {

    }

    @Before("httpLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //URL
        logger.info("url:{}", request.getRequestURL());
        //Request method
        logger.info("method:{}", request.getMethod());
        //IP
        logger.info("ip:{}", request.getRemoteAddr());
        //Class method name
        logger.info("method:{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // Argument
        logger.info("args:{}", JSONUtil.toJSONString(joinPoint.getArgs()));
    }

    @After("httpLog()")
    public void doAfter() {
        logger.info("request cost time:{} ms", System.currentTimeMillis() - startTime.get());
    }

    @AfterReturning(returning = "object", pointcut = "httpLog()")
    public void afterReturning(Object object) {
        logger.info("response:{}", JSONUtil.toJSONString(object));
    }
}
