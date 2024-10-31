package com.example.Uber.dto;

import com.example.Uber.entities.enus.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SignupDto {

    private String name;

    private String email;

    private String password;

    private Set<Role> roles;
}
