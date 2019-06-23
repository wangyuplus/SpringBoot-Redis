

package com.example.ssmspringboot.aspect;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.util.logging.Logger;

@Aspect
@Configuration
public class HttpAspect {
    private final  static org.slf4j.Logger logger =LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut ("execution(public * com.example.ssmspringboot.controller.UserController.login(..))")
    public void HttpAspect(){

    }
    @Before  ("HttpAspect()")
    public void HttpaAspect1(){
        logger.info("Before");
        System.out.println("login()开始");
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());

    }
   @After ("HttpAspect()")
   public void HttpaAspect2(){
        logger.info("after");
       System.out.println("login()结束");
   }
   @AfterReturning(returning = "object",pointcut="HttpAspect()")
    public void  HttpAspect3(Object object){
  logger.info("reponse={}",object);
   }

}


