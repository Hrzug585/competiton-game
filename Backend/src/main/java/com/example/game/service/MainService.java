package com.example.game.service;

import com.example.game.model.Solution;
import com.example.game.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private TasksService tasksService;
    private CompilerService compilerService;

    @Autowired
    public MainService(TasksService tasksService, CompilerService compilerService) {
        this.tasksService = tasksService;
        this.compilerService = compilerService;
    }

    public void postSolution(Solution solution) {
        //TODO get data from db, send to compiler endpoint
        //get Task from db
        Task task = tasksService.getTaskById((long)solution.getTaskId());

        compilerService.sendSolution(solution, task);
    }
}
