package com.example.challenge.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ContactDTO {
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Email
    @NotEmpty(message = "userid cannot be empty")
    private String email;

    private String message;

    private String interest;
}