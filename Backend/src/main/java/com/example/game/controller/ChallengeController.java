package com.example.game.controller;

import com.example.game.model.Solution;
import com.example.game.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/challenge")
@CrossOrigin(origins = "http://localhost:4200")
public class ChallengeController {
    private MainService mainService;

    @Autowired
    public ChallengeController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping(produces = {"application/json"}, consumes = "application/json")
    public HttpEntity postSolution(@RequestBody final Solution solution) {
        return mainService.postSolution(solution);
    }
}
