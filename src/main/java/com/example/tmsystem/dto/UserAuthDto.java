package com.example.tmsystem.dto;

public record UserAuthDto(
        String name,
        String surname,
        String email,
        String password,
        RoleDto role
) {

}