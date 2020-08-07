package com.bz.cadenceclient.activities;

import com.uber.cadence.worker.Worker;

/**
 * @author:11411
 * @date: 2020/8/7 13:47
 **/
public class GettingStartedWorkflowWorker {

    public static void main(String[] args) {
        Worker.Factory factory = new Worker.Factory("192.168.5.210",7933,"test-domain");
        Worker worker = factory.newWorker("HelloWorldTaskList");
        worker.registerWorkflowImplementationTypes(HelloWorldImpl.class);
        factory.start();

    }
}
