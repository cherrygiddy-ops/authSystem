package com.authservice.system.users;


import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(RegistrationDto requestDto);

    UserResponseDto toDto(User userEntity);
}
