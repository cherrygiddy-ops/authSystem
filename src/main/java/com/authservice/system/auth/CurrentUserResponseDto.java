package com.authservice.system.auth;

import com.authservice.system.users.Role;
import lombok.Data;

@Data
public class CurrentUserResponseDto {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
