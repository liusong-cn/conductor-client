package com.bz.cadenceclient.activities;

import com.uber.cadence.activity.ActivityMethod;

/**
 * @author:11411
 * @date: 2020/8/7 15:01
 **/
public interface BeforeHelloActivity {

    @ActivityMethod(scheduleToCloseTimeoutSeconds = 1000)
    String offer(String mes);

}
