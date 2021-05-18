package com.example.game.service;

import com.example.game.model.CompilerResponse;
import com.example.game.model.Solution;
import com.example.game.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity postSolution(Solution solution) {
        Task task = tasksService.getTaskById((long)solution.getTaskId());
        CompilerResponse compilerResponse = compilerService.sendSolution(solution);

        if(compilerResponse.getOutput().startsWith(task.getOutputTest())){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
