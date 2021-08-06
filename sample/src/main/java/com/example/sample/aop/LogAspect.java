package com.example.sample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object checkSomethingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("Args={}",joinPoint.getArgs());
        Object result = joinPoint.proceed();
        LOG.info("Response={}",result);
        return result;
    }
}
