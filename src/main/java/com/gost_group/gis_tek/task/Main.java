package com.gost_group.gis_tek.task;

import java.util.Set;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.reflections.Reflections;

/**
 * @author spirin87@gmail.com
 * <p>
 * Feb 11, 2015, 10:52:52 AM
 */
public class Main {

    public static void main(String[] args) throws Throwable {

        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();

        Reflections reflections = new Reflections("com.gost_group.gis_tek.task.example");
        Set<Class<? extends Runnable>> tasks = reflections.getSubTypesOf(Runnable.class);
        for (Class<? extends Runnable> clazz : tasks) {

            JobDetail job = JobBuilder.newJob(JobWrapper.class).usingJobData(JobWrapper.JOB_DETAIL_KEY, clazz.getName()).build();

            SimpleScheduleBuilder repeatForever = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();

            Trigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(repeatForever).build();
            scheduler.scheduleJob(job, trigger);

        }
    }
}