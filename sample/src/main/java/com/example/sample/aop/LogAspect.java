package com.example.sample.aop;

import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import com.example.sample.dto.res.Response;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@ConditionalOnExpression(
  "${app.logApi:true}"
)
@Slf4j
public class LogAspect {

    @Pointcut("within(com.example.sample..*)")
    public void packagePoint() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void apiPoint() {}

    @Around("packagePoint() && apiPoint()")
    public Object apiAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String requestId = RandomStringUtils.random(15, true, true);
        String oldThreadName = Thread.currentThread().getName();
        Thread.currentThread().setName(requestId);
        LOG.info("Request={}",joinPoint.getArgs());

        Object result;
        try {
            result = joinPoint.proceed();
        }catch (Exception e) {
            result = Response.fail(e.getMessage());
            LOG.warn("Controller process error", e);
        }

        if (result instanceof Response) {
            ((Response) result).setRequestId(requestId);
        }
        LOG.info("Response={}",result);
        Thread.currentThread().setName(oldThreadName);
        return result;
    }
}
