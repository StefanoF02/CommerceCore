package com.commercecore.userService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @NotNull
    private UUID uid;

    @NotBlank(message = "Firstname be set.")
    private String firstname;

    @NotBlank(message = "Lastname must be set.")
    private String lastname;

    @NotBlank(message = "Email must not be set.")
    private String email;

    @NotBlank(message = "Telephone must be set.")
    private Integer telephone;

    @NotBlank(message = "age must be set.")
    private Integer age;

    @NotBlank(message = "Password must be set.")
    private String password;

    @NotBlank(message = "Role must be set.")
    private String role;
}
