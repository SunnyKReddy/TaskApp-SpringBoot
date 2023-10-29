package com.learnleadgrow.taskapp.controller;

import com.learnleadgrow.taskapp.dto.TaskRequestDTO;
import com.learnleadgrow.taskapp.dto.TaskResponseDTO;
import com.learnleadgrow.taskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/{userId}/create")
    public ResponseEntity<TaskResponseDTO> createTask(@PathVariable(name = "userId") long userId,
                                                      @RequestBody TaskRequestDTO taskRequestDTO) {
        return new ResponseEntity<>(taskService.createTask(userId, taskRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/usertasks/{userId}")
    public ResponseEntity<List<TaskResponseDTO>> getTasks(@PathVariable(name = "userId") long userId) {
        return new ResponseEntity<>(taskService.getTasks(userId), HttpStatus.OK);
    }
}
