package com.bz.cadenceclient;

import com.uber.cadence.worker.Worker;
import com.uber.cadence.workflow.SignalMethod;
import com.uber.cadence.workflow.Workflow;
import com.uber.cadence.workflow.WorkflowMethod;
import org.slf4j.Logger;

import java.util.Objects;

/**
 * @author:11411
 * @date: 2020/8/6 15:29
 **/
public class GettingStarted {

    private static Logger logger = Workflow.getLogger(GettingStarted.class);

    public interface HelloWorld{

        @WorkflowMethod
        void sayHello(String name);

        //每次有消息发送过来则执行
        @SignalMethod
        void updateGreeting(String greeting);
    }

    public static  class HelloWorldImpl implements HelloWorld{

        private String greeting = "hello";

        @Override
        public void sayHello(String name) {
            int count = 0;
            while (!"bye".equals(greeting)){
                logger.info(++count + ":" + greeting + " " + name + "!");
                String oldGreeting = greeting;
                //为true则释放锁，此处要求新旧消息不一致
                Workflow.await(()-> !Objects.equals(greeting,oldGreeting));
            }
            logger.info(++count + ":" + greeting + " " + name + "!");
        }

        @Override
        public void updateGreeting(String greeting) {
            this.greeting = greeting;
        }
    }

    public static void main(String[] args) {
        Worker.Factory factory = new Worker.Factory("192.168.5.210",7933,"test-domain");
        Worker worker = factory.newWorker("HelloWorldTaskList");
        worker.registerWorkflowImplementationTypes(HelloWorldImpl.class);
        factory.start();
    }


}
