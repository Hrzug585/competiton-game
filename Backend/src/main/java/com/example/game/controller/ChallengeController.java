package com.example.game.controller;

import com.example.game.model.Solution;
import com.example.game.model.TestCaseReponse;
import com.example.game.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * ChallengeController is responsible for challenges - simple coding tasks
 * */

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    private final ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PostMapping(value = "/v1/submit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<List<TestCaseReponse>> postSolution(@RequestBody final Solution solution) {
        return new HttpEntity<>(challengeService.analyzeSolution(solution));
    }
}
