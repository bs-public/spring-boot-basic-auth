package com.mapper;

import com.dto.UserDTO;
import com.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(source = "role.rolename", target = "role")
  UserDTO toDTO(User user);

  @Mapping(target = "role", ignore = true)
  User toEntity(UserDTO dto);
}
