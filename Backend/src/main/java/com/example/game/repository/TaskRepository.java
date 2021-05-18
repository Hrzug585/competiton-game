package com.example.game.repository;

import com.example.game.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM tasks t WHERE t.taskId = ?1")
    Task findTaskByTaskId(Long id);
}
