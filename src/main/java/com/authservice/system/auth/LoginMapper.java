package com.authservice.system.auth;

import com.authservice.system.users.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {
    CurrentUserResponseDto toDto (User user);
}
