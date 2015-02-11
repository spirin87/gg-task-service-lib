package com.gost_group.gis_tek.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.gost_group.gis_tek.task.modeshape.ModeShapeService;

/**
 * @author spirin87@gmail.com
 * <p>
 * Feb 5, 2015, 11:24:42 AM
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class BootApplication {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private ModeShapeService modeShapeService;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);
    }

    @Scheduled(fixedRate = 20000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
        System.out.println(modeShapeService);
        modeShapeService.test();
    }
}