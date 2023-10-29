package com.learnleadgrow.taskapp.service;

import com.learnleadgrow.taskapp.dto.UserResponseDTO;
import com.learnleadgrow.taskapp.model.User;

import java.util.List;

public interface UserService {
    public UserResponseDTO registerUser(User user);

    public UserResponseDTO getUser(long userId);
    public List<UserResponseDTO> getAllUsers();
}
