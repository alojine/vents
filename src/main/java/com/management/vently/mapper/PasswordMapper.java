package com.management.vently.mapper;

import com.management.vently.domain.DTO.PasswordDTO;
import com.management.vently.domain.model.Password;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PasswordMapper {

    @Mapping(target = "applicationName", source = "dto.applicationName")
    @Mapping(target = "emailAddress", source = "dto.emailAddress")
    @Mapping(target = "password", source = "dto.password")
    Password passwordDTOtoPassword(PasswordDTO dto);

    @Mapping(target = "applicationName", source = "entity.applicationName")
    @Mapping(target = "emailAddress", source = "entity.emailAddress")
    @Mapping(target = "password", source = "entity.password")
    @Mapping(target = "userId", source = "entity.user")
    PasswordDTO passwordToPasswordDTO(Password entity);

    List<PasswordDTO> passwordListToPasswordDTOList(List<Password> passwords);
}
