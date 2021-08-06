package com.example.sample.aop;

import com.example.sample.dto.res.Response;
import org.apache.commons.lang3.RandomStringUtils;
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

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object apiAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String requestId = RandomStringUtils.random(15, true, true);
        String oldThreadName = Thread.currentThread().getName();
        Thread.currentThread().setName(requestId);
        LOG.info("Request={}",joinPoint.getArgs());
        Object result = joinPoint.proceed();
        if (result instanceof Response) {
            ((Response) result).setRequestId(requestId);
        }
        LOG.info("Response={}",result);
        Thread.currentThread().setName(oldThreadName);
        return result;
    }
}
