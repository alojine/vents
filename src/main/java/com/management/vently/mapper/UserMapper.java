package com.management.vently.mapper;

import com.management.vently.mapper.entity.UserDTO;
import com.management.vently.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(target = "firstname", source = "dto.firstname")
    @Mapping(target = "lastname", source = "dto.lastname")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "role", source = "dto.role")
    User userDTOtoUser(UserDTO dto);


    @Mapping(target = "firstname", source = "entity.firstname")
    @Mapping(target = "lastname", source = "entity.lastname")
    @Mapping(target = "email", source = "entity.email")
    @Mapping(target = "role", source = "entity.role")
    UserDTO userToUserDTO(User entity);

    List<UserDTO> userListToUserDTOList(List<User> users);
}
