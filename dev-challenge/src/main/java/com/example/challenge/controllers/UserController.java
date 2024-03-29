package com.example.challenge.controllers;


import com.example.challenge.dtos.UserDTO;
import com.example.challenge.dtos.UserResponseDTO;
import com.example.challenge.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/create_user")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserDTO user) {
        try {
            UserResponseDTO response = userService.createUser(user);
            return ResponseEntity.ok().body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserResponseDTO(e.getMessage()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new UserResponseDTO("Internal Server Error"));
        }
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        try {
            List<UserResponseDTO> users = userService.getAllUsers();
            return ResponseEntity.ok().body(users);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> editUser(@PathVariable String userId, @RequestBody UserDTO user) {
        try {
            UserResponseDTO response = userService.editUser(userId, user);
            return ResponseEntity.ok().body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(new UserResponseDTO(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new UserResponseDTO("Internal Server Error"));
        }
    }
}
