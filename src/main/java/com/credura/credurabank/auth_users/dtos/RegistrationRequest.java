package com.credura.credurabank.auth_users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class RegistrationRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

    private List<String> roles;

    @NotBlank(message = "Password is required")
    private String password;


}
