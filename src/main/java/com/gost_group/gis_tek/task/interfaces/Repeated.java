package com.gost_group.gis_tek.task.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author spirin87@gmail.com
 * <p>
 * Feb 11, 2015, 1:58:26 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Repeated {

    RepeatType type();

    int interval();
}