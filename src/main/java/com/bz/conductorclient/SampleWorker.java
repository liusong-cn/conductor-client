package com.bz.conductorclient;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;

/**
 * @author:11411
 * @date: 2020/8/3 17:05
 **/
public class SampleWorker implements Worker {
    private String taskDefName;

    public SampleWorker(String taskDefName){
        this.taskDefName = taskDefName;
    }

    @Override
    public String getTaskDefName() {
        return taskDefName;
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);
        result.setStatus(TaskResult.Status.COMPLETED);
        result.getOutputData().put("is_idents_added","false");
        System.out.println("task开始执行");
        return result;
    }
}
