package com.authservice.system.users;

import lombok.Data;

@Data
public class UserResponseDto {
    private Integer id;
    private String username;
    private String email;
}
