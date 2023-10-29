package com.learnleadgrow.taskapp.repository;

import com.learnleadgrow.taskapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserId(long userId);
}
