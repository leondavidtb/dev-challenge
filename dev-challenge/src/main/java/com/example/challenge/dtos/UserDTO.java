package com.example.challenge.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDTO {

    @Email(message = "Invalid email format")
    @NotEmpty(message = "userid cannot be empty")
    private String userid;

    @NotEmpty(message = "password cannot be empty")
    private String password;

    @NotEmpty(message = "fullname cannot be empty")
    private String fullname;

    private String birthdate;
}
