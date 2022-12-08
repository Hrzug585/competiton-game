package com.example.game.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Long taskId;
    @Column(name = "task_name", nullable = false)
    private String task_name;
    private String description;
    @Column(name = "input_test")
    private int inputTest;
    @Column(name = "output_test")
    private String outputTest;

    public Task(Long taskId, String task_name, String description, int inputTest, String outputTest) {
        this.taskId = taskId;
        this.task_name = task_name;
        this.description = description;
        this.inputTest = inputTest;
        this.outputTest = outputTest;
    }

    public Task() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String taskName) {
        this.task_name = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInputTest() {
        return inputTest;
    }

    public void setInputTest(int inputTest) {
        this.inputTest = inputTest;
    }

    public String getOutputTest() {
        return outputTest;
    }

    public void setOutputTest(String outputTest) {
        this.outputTest = outputTest;
    }
}
