package com.example.challenge1.dtos;

import lombok.Data;

@Data
public class ContactResponseDTO {

        private String msg;

        // Default constructor (no-argument)
        public ContactResponseDTO() {
        }

        // Constructor with a message argument
        public ContactResponseDTO(String msg) {
                this.msg = msg;
        }
}
