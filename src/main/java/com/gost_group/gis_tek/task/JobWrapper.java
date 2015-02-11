package com.gost_group.gis_tek.task;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author spirin87@gmail.com
 * <p>
 * Feb 11, 2015, 1:51:48 PM
 */
public class JobWrapper implements Job {

    public static final String JOB_DETAIL_KEY = "RUNNABLE_CLASS";

    private static final Logger log = Logger.getLogger(JobWrapper.class);

    private Runnable instance;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            if (instance == null) {
                createInstance(context);
            }
            instance.run();
        } catch (Throwable t) {
            log.error(instance.getClass() + " execution error");
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Runnable> void createInstance(JobExecutionContext context) {
        try {
            String className = (String) context.getJobDetail().getJobDataMap().get(JOB_DETAIL_KEY);
            if (className != null) {
                Class<? extends Runnable> clazz = (Class<? extends Runnable>) Class.forName(className);
                instance = clazz.newInstance();
            } else {
                throw new RuntimeException("Can't find class an jobDataMap by key: " + JOB_DETAIL_KEY);
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            log.error("creation error:", e);
            throw new RuntimeException("Can't create instance");
        }
    }
}
