package com.bz.conductorclient.conductor.config;

import com.bz.conductorclient.SampleWorker;
import com.netflix.conductor.client.automator.TaskRunnerConfigurer;
import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.worker.Worker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author:11411
 * @date: 2020/8/4 16:21
 **/
@Component
//value越小优先级越高
@Order(value = 1)
public class TaskRunnerConfig implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        TaskClient taskClient = new TaskClient();
        taskClient.setRootURI("http://192.168.5.210:8080/api/");
        int threadCoun = 2;
        Worker worker1 = new SampleWorker("verify_if_idents_are_added");
        Worker worker2 = new SampleWorker("add_idents");
        TaskRunnerConfigurer configurer = new TaskRunnerConfigurer.Builder(taskClient, Arrays.asList(worker1,worker2))
                .withThreadCount(threadCoun).build();
        configurer.init();
        System.out.println("taskRunnerConfigurer is started");
    }
}
