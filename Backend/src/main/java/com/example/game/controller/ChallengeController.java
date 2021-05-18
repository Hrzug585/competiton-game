package com.example.game.controller;

import com.example.game.model.Solution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/challenge")
public class ChallengeController {

    @PostMapping(produces={"application/json"}, consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public void postSolution(@RequestBody final Solution solution) {
        
    }
}
