package com.example.sample.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultJob implements Job{

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Long startTime = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Thread.sleep(2000);
            Long endTime = System.currentTimeMillis();
            LOG.info("执行任务，执行时间：{},耗时:{}", format.format(new Date(startTime)), (endTime-startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
