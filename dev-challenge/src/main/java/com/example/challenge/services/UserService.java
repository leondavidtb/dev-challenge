package com.example.challenge.services;

import com.example.challenge.dtos.UserDTO;
import com.example.challenge.dtos.UserResponseDTO;
import com.example.challenge.entities.UserEntity;
import com.example.challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public UserResponseDTO editUser(String userId, UserDTO user) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            existingUser.setFullname(user.getFullname());
            existingUser.setBirthdate(user.getBirthdate());
            userRepository.save(existingUser);
            return new UserResponseDTO("User edited successfully");
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
    }
}
