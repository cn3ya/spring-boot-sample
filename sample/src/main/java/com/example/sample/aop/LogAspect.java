package com.example.sample.aop;

import com.example.sample.dto.res.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

@Aspect
@Component
@ConditionalOnExpression(
  "${app.logApi:true}"
)
public class LogAspect {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

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
