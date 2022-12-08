package com.example.game.service;

import com.example.game.model.CompilerResponse;
import com.example.game.model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
    private CompilerService compilerService;

    @Autowired
    public ChallengeService(CompilerService compilerService) {
        this.compilerService = compilerService;
    }

    public ResponseEntity<CompilerResponse> analyzeSolution(Solution solution) {
        //TODO create and send out testcases
        CompilerResponse compilerResponse = compilerService.sendSolution(solution);
        return new ResponseEntity<>(compilerResponse, HttpStatus.OK);
    }
}
