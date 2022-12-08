package com.example.game.service;

import com.example.game.model.CompilerResponse;
import com.example.game.model.Solution;
import com.example.game.model.TestCaseDTO;
import com.example.game.model.TestCaseReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private CompilerService compilerService;
    private TasksService tasksService;

    @Autowired
    public ChallengeService(CompilerService compilerService, TasksService tasksService) {
        this.compilerService = compilerService;
        this.tasksService = tasksService;
    }

    public List<TestCaseReponse> analyzeSolution(Solution solution) {
        List<TestCaseDTO> testCases = tasksService.createTestCases(solution);
        List<TestCaseReponse> responseList = new ArrayList<>();
        testCases.forEach(testCaseDTO ->
                responseList.add(fromCompilerResponse(compilerService.sendSolution(testCaseDTO.getScript()), testCaseDTO)));

        return responseList;
    }

    private TestCaseReponse fromCompilerResponse(CompilerResponse response, TestCaseDTO testCaseDTO) {
        return TestCaseReponse.builder()
                .input(testCaseDTO.getInput())
                .cpuTime(response.getCpuTime())
                .error(response.getError())
                .expectedOutput(response.getOutput())
                .memory(response.getMemory())
                .statusCode(response.getStatusCode())
                .output(response.getOutput())
                .build();
    }
}
