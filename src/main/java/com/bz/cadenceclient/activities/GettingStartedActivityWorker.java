package com.bz.cadenceclient.activities;

import com.uber.cadence.worker.Worker;

/**
 * @author:11411
 * @date: 2020/8/7 11:34
 **/
public class GettingStartedActivityWorker {
    public static void main(String[] args) {
        Worker.Factory factory = new Worker.Factory("192.168.5.210",7933,"test-domain");
        Worker worker = factory.newWorker("HelloWorldTaskList");
        worker.registerActivitiesImplementations(new HelloActivityImpl(System.out));
        factory.start();
    }
}
