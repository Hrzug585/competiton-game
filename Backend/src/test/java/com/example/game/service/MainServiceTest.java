package com.example.game.service;

import com.example.game.model.CompilerResponse;
import com.example.game.model.Solution;
import com.example.game.model.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class MainServiceTest {
    private MainService mainService;
    private TasksService tasksService;
    private CompilerService compilerService;


    @Before
    public void setUp() {
        tasksService = Mockito.mock(TasksService.class);
        compilerService = Mockito.mock(CompilerService.class);
        mainService = new MainService(tasksService, compilerService);

    }

    @Test
    public void whenOutputsAreTheSameReturnHttpOk() {
        Task task = new Task(1l, "task_name", "description", 10, "0 1 1 2 3 5 8 13 21 34 55");
        CompilerResponse compilerResponse = new CompilerResponse();
        compilerResponse.setOutput("0 1 1 2 3 5 8 13 21 34 55");
        when(tasksService.getTaskById(anyLong())).thenReturn(task);
        when(compilerService.sendSolution(any())).thenReturn(compilerResponse);

        ResponseEntity response = mainService.postSolution(new Solution());
        ResponseEntity expectedResponse = new ResponseEntity(HttpStatus.OK);

        Assert.assertEquals(expectedResponse, response);
    }

    @Test
    public void whenOutputsAreDifferentReturnBadRequest() {
        Task task = new Task(1l, "task_name", "description", 10, "test");
        CompilerResponse compilerResponse = new CompilerResponse();
        compilerResponse.setOutput("0 1 1 2 3 5 8 13 21 34 55");
        when(tasksService.getTaskById(anyLong())).thenReturn(task);
        when(compilerService.sendSolution(any())).thenReturn(compilerResponse);

        ResponseEntity response = mainService.postSolution(new Solution());
        ResponseEntity expectedResponse = new ResponseEntity(HttpStatus.BAD_REQUEST);

        Assert.assertEquals(expectedResponse, response);
    }
}