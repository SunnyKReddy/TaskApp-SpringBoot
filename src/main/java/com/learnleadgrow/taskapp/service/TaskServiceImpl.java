package com.learnleadgrow.taskapp.service;

import com.learnleadgrow.taskapp.dto.TaskRequestDTO;
import com.learnleadgrow.taskapp.dto.TaskResponseDTO;
import com.learnleadgrow.taskapp.dto.UserResponseDTO;
import com.learnleadgrow.taskapp.exception.UserNotFoundException;
import com.learnleadgrow.taskapp.model.Task;
import com.learnleadgrow.taskapp.model.User;
import com.learnleadgrow.taskapp.repository.TaskRepository;
import com.learnleadgrow.taskapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskResponseDTO createTask(long userId, TaskRequestDTO taskRequestDTO) {
        //User user = userRepository.findById(userId).get();
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User with %d Id 'Not Found' in DB", userId))
        );
        Task task = modelMapper.map(taskRequestDTO, Task.class);
        task.setUser(user);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskResponseDTO.class);
    }

    @Override
    public List<TaskResponseDTO> getTasks(long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User with %d Id 'Not Found' in DB", userId))
        );
        List<Task> tasks = taskRepository.findAllByUserId(userId);
        return tasks.stream().map(
                task -> modelMapper.map(task, TaskResponseDTO.class)
        ).collect(Collectors.toList());
    }
}
