package com.example.tmsystem.dto;

import java.util.List;

public record UserDto(
        Integer id,
        String name,
        String surname,
        String email,
        RoleDto role
) {

}
