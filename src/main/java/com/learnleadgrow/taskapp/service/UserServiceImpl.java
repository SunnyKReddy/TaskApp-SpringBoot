package com.learnleadgrow.taskapp.service;

import com.learnleadgrow.taskapp.dto.UserResponseDTO;
import com.learnleadgrow.taskapp.exception.UserNotFoundException;
import com.learnleadgrow.taskapp.model.User;
import com.learnleadgrow.taskapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserResponseDTO registerUser(User user) {
        User savedUser = userRepository.save(user);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setName(savedUser.getName());
        userResponseDTO.setEmail(savedUser.getEmail());
        userResponseDTO.setPassword(savedUser.getPassword());
        return userResponseDTO;
    }
    @Override
    public UserResponseDTO getUser(long userId) {
        //User user = userRepository.findById(userId).get();
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.format("User with %d Id 'Not Found' in DB",userId))
        );
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(
                user -> modelMapper.map(user, UserResponseDTO.class)
        ).collect(Collectors.toList());
    }
}
