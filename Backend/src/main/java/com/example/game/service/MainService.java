package com.example.game.service;

import com.example.game.model.Solution;
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
    }
}
