package com.example.challenge.dtos;

import lombok.Data;

@Data
public class UserResponseDTO {

        private String msg;

        // Constructor with a message argument
        public UserResponseDTO(String msg) {
                this.msg = msg;
        }
}
