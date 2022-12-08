package com.example.game.service;

import com.example.game.model.Solution;
import com.example.game.model.TaskInfo;
import com.example.game.model.TestCaseDTO;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksService {
    //TODO call repository service and fetch data
    private TaskInfo taskInfo;

    @Autowired
    public TasksService(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    public List<TestCaseDTO> createTestCases(Solution solution) {
        return getTestCasesById(solution.getTaskId())
                .stream()
                .map(testCase ->
                        TestCaseDTO.builder()
                                .id(testCase.getId())
                                .script(generateTestCase(solution.getScript(), testCase))
                                .input(testCase.getInput())
                                .output(testCase.getOutput())
                                .build()
                )
                .collect(Collectors.toList());

    }

    private List<TaskInfo.TestCase> getTestCasesById(int taskId) {
        return taskInfo.getTaskInfo()
                .stream()
                .filter(task -> task.getId() == taskId)
                .findFirst()
                .map(TaskInfo.Task::getTestCases)
                .orElse(new ArrayList<>());
    }

    private String generateTestCase(String script, TaskInfo.TestCase testCase) {
        JavaClassSource javaClass = Roaster.parse(JavaClassSource.class, script);
        javaClass.addMethod()
                .setPublic()
                .setName("main")
                .setStatic(true)
                .setReturnTypeVoid()
                .setBody("System.out.print(isEven(" + testCase.getInput() + "));")
                .addParameter("java.lang.String[]", "args");
        return javaClass.toString();
    }
}
