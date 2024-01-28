package com.example.challenge.dtos;

import lombok.Data;

@Data
public class ContactResponseDTO {

        private String msg;

        // Constructor with a message argument
        public ContactResponseDTO(String msg) {
                this.msg = msg;
        }
}
