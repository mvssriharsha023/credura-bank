package com.credura.credurabank.auth_users.dtos;

import com.credura.credurabank.account.dtos.AccountDTO;
import com.credura.credurabank.role.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    @JsonIgnore
    private String password;

    private String profilePictureUrl;

    private boolean active;

    private List<Role> roles;

    @JsonManagedReference // it helps avoid recursion loop by ignoring the userDTO within the AccountDTO
    private List<AccountDTO> accounts;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
