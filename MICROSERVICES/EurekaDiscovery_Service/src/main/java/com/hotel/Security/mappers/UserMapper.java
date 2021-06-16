package com.hotel.Security.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hotel.Security.dto.UserDto;
import com.hotel.Security.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "user.role", target = "role")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "token", target = "token")
    UserDto toUserDto(User user, String token);
}
