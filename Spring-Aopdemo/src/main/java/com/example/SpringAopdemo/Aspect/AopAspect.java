package com.example.SpringAopdemo.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(AopAspect.class);


@Before("execution(* com.example.SpringAopdemo.Service.AopService.getHelloMsg(..))")
    public void beforeHelloMsg(){
        LOGGER.info("Exceuting before method ");
    }

 @After("execution(* com.example.SpringAopdemo.Service.AopService.getHelloMsg(..))")
 public void afterHelloMsg(){
    LOGGER.info("Executing after method");
 }

 @Around("@annotation(com.example.SpringAopdemo.Aspect.LogExecutionTime)")
    public Object logExceutionTimeOfmethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
    long start = System.currentTimeMillis();


    Object result = proceedingJoinPoint.proceed();

    long end =System.currentTimeMillis();

    LOGGER.info("Exceution Time :{} ms",end-start);

    return result;

 }

}
