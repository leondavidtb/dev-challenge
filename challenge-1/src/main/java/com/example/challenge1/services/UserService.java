package com.example.challenge1.services;

import com.example.challenge1.dtos.UserDTO;
import com.example.challenge1.dtos.UserResponseDTO;
import com.example.challenge1.entities.UserEntity;
import com.example.challenge1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserDTO user) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserid(user.getUserid());
            userEntity.setPassword(user.getPassword());
            userEntity.setFullname(user.getFullname());
            userEntity.setBirthdate(user.getBirthdate());
            userRepository.save(userEntity);
            return new UserResponseDTO("User created successfully");
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating user: " + e.getMessage());
        }
    }

    public List<UserResponseDTO> getAllUsers() {
        try {
            List<UserEntity> users = userRepository.findAll();
            return users.stream()
                    .map(userEntity -> new UserResponseDTO(
                            "User ID: " + userEntity.getUserid() +
                                    ", Full Name: " + userEntity.getFullname() +
                                    ", Birthdate: " + userEntity.getBirthdate()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving users: " + e.getMessage());
        }
    }
}
