package com.example.challenge1.services;

import com.example.challenge1.dtos.UserDTO;
import com.example.challenge1.dtos.UserResponseDTO;
import com.example.challenge1.entities.UserEntity;
import com.example.challenge1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserDTO user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(user.getUserid());
        userEntity.setPassword(user.getPassword());
        userEntity.setFullname(user.getFullname());
        userEntity.setBirthdate(user.getBirthdate());

        userRepository.save(userEntity);

        return new UserResponseDTO("User created successfully");
    }
}
