package com.bz.cadenceclient.activities;

import com.uber.cadence.activity.ActivityMethod;

/**
 * @author:11411
 * @date: 2020/8/7 11:20
 * activity可以调用外部api，而workflow不可以
 **/
public interface HelloActivity {

    /**
     * 通过注解配置超时等规则比cli配置简单
     */
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 100)
    void say(String mes);
}
