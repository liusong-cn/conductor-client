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
    }


}
