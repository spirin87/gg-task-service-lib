package com.gost_group.gis_tek.task.example;

import java.util.Date;

import com.gost_group.gis_tek.task.interfaces.RepeatType;
import com.gost_group.gis_tek.task.interfaces.Repeated;

/**
 * @author spirin87@gmail.com
 * <p>
 * Feb 11, 2015, 1:53:58 PM
 */
@Repeated(type = RepeatType.SECOND, interval = 10)
public class SimpleTask implements Runnable {

    @Override
    public void run() {
        System.out.println("SimpleTask.run()");
        System.out.println(new Date());
    }
}
