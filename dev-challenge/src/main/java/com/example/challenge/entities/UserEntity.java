package com.example.challenge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Base64;

@Entity
@Data
public class UserEntity {

    @Id
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is mandatory")
    private String userid;
    private String password;
    private String fullname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthdate;

    public void setPassword(String password) {
        this.password = Base64.getEncoder().encodeToString(password.getBytes());
    }
}

