package com.example.challenge1.dtos;

import lombok.Data;

@Data
public class UserResponseDTO {

        private String msg;

        // Default constructor (no-argument)
        public UserResponseDTO() {
        }

        // Constructor with a message argument
        public UserResponseDTO(String msg) {
                this.msg = msg;
        }
}
