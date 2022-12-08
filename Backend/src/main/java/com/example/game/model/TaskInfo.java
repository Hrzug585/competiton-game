package com.example.game.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskInfo {
    private List<Task> taskInfo;

    @Getter
    @Setter
    public static class Task {
        private int id;
        private String description;
        private List<TestCase> testCases;
    }

    @Getter
    @Setter
    public static class TestCase {
        private int id;
        private String input;
        private String output;
    }
}
