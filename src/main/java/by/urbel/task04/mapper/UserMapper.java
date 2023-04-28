package by.urbel.task04.mapper;

import by.urbel.task04.dto.AdminDto;
import by.urbel.task04.dto.SignUpRequest;
import by.urbel.task04.dto.UserDto;
import by.urbel.task04.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User convert(SignUpRequest dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(by.urbel.task04.entity.enums.Role.ROLE_ADMIN)")
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User convert(AdminDto dto);

    UserDto convert(User user);


    List<UserDto> convert(List<User> users);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User convert(UserDto dto);
}
