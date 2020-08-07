package com.bz.cadenceclient.activities;

import com.uber.cadence.workflow.Workflow;

import java.util.Objects;

/**
 * @author:11411
 * @date: 2020/8/7 13:21
 **/
public class HelloWorldImpl implements  HelloWorld {

    private String greeting = "Hello";

    private int count = 0;

    private final HelloActivity activity = Workflow.newActivityStub(HelloActivity.class);

    private final BeforeHelloActivity beforeActivity = Workflow.newActivityStub(BeforeHelloActivity.class);

    @Override
    public void sayHello(String name) {
        while (!"bye".equals(greeting)){
            //模拟服务的串行调用，当上一个activity产生结果后下一个activity才开始执行
            String result = beforeActivity.offer(name);
            activity.say(++count + ": " + greeting + " " + result + "!");
            String oldGreeting  = greeting;
            Workflow.await(()->!Objects.equals(oldGreeting,greeting));
        }
        activity.say(++count + ": " + greeting + " " + name + "!");
    }

    @Override
    public void updateGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public int getCount() {
        return count;
    }
}
