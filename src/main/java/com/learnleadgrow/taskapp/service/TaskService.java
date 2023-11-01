package com.learnleadgrow.taskapp.service;

import com.learnleadgrow.taskapp.dto.TaskRequestDTO;
import com.learnleadgrow.taskapp.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {
    // Create Task
    public TaskResponseDTO createTask(long userId, TaskRequestDTO taskRequestDTO);
    public List<TaskResponseDTO> getTasks(long userId);

    public TaskResponseDTO updateTask(long userId, long taskId, TaskRequestDTO taskRequestDTO);
    public String deleteTask(long userId, long taskId);
}
