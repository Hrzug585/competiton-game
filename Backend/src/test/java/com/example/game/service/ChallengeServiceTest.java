package com.example.game.service;

import com.example.game.model.CompilerResponse;
import com.example.game.model.Solution;
import com.example.game.model.TestCaseDTO;
import com.example.game.model.TestCaseReponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ChallengeServiceTest {
    private ChallengeService challengeService;
    private TasksService tasksService;
    private CompilerService compilerService;


    @Before
    public void setUp() {
        tasksService = Mockito.mock(TasksService.class);
        compilerService = Mockito.mock(CompilerService.class);
        challengeService = new ChallengeService(compilerService, tasksService);

    }

    @Test
    public void whenNoTestCasesReturnsEmptyResponse() {
        // Arrange
        var solution = new Solution();

        when(tasksService.createTestCases(solution)).thenReturn(new ArrayList<>());

        // Act
        var response = challengeService.analyzeSolution(solution);

        // Assert
        assert(response.isEmpty());
    }

    @Test
    public void whenAnalyzeSolutionMapsResponseFromCompiler() {
        // Arrange
        var expectedResponse = Collections.singletonList(TestCaseReponse.builder()
                .expectedOutput("true")
                .output("true")
                .statusCode(200)
                .memory(123));

        var solution = new Solution();
        solution.setScript("script");
        solution.setTaskId(1);
        solution.setTaskName("task_name");

        var compilerResponse = new CompilerResponse();
        compilerResponse.setOutput("true");
        compilerResponse.setStatusCode(200);
        compilerResponse.setMemory(123);

        var testCases = Collections.singletonList(TestCaseDTO.builder().id(1).output("true").script("script").build());

        when(tasksService.createTestCases(solution)).thenReturn(testCases);
        when(compilerService.sendSolution(any())).thenReturn(compilerResponse);

        // Act
        var response = challengeService.analyzeSolution(solution);

        // Assert
        assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
    }

}