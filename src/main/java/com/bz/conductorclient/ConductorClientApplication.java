package com.bz.conductorclient;

import com.netflix.conductor.client.automator.TaskRunnerConfigurer;
import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.worker.Worker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ConductorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConductorClientApplication.class, args);
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
