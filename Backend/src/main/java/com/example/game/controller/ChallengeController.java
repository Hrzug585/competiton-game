package com.example.game.controller;

import com.example.game.model.Solution;
import com.example.game.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/challenge")
public class ChallengeController {
    private MainService mainService;

    @Autowired
    public ChallengeController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping(produces={"application/json"}, consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public void postSolution(@RequestBody final Solution solution) {
        mainService.postSolution(solution);
    }
}
