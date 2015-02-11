package com.gost_group.gis_tek.task;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author spirin87@gmail.com
 * <p>
 * Feb 11, 2015, 12:11:50 PM
 */
public class MyJob implements Job {

    private static final Logger log = Logger.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("MyJob.execute()");
    }
}
