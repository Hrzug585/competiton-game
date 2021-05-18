package com.example.game.service;

import com.example.game.model.Task;
import com.example.game.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
    //TODO call repository service and fetch data
    private TaskRepository taskRepository;

    @Autowired
    public TasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(Long taskId) {
        System.out.println(taskRepository.findTaskByTaskId(taskId));
        return taskRepository.findTaskByTaskId(taskId);
    }
}
