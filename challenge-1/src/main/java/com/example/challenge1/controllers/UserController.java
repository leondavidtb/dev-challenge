package com.example.challenge1.controllers;


import com.example.challenge1.dtos.UserDTO;
import com.example.challenge1.dtos.UserResponseDTO;
import com.example.challenge1.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

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
}
