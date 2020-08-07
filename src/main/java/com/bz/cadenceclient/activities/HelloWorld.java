package com.bz.cadenceclient.activities;

import com.uber.cadence.workflow.QueryMethod;
import com.uber.cadence.workflow.SignalMethod;
import com.uber.cadence.workflow.WorkflowMethod;

/**
 * @author:11411
 * @date: 2020/8/7 11:54
 **/
public interface HelloWorld {

    @WorkflowMethod
    void sayHello(String name);

    @SignalMethod
    void updateGreeting(String greeting);

    @QueryMethod
    int getCount();
}
