package ru.nikolotov.t1task3.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nikolotov.t1task3.dto.CreateUserDto;
import ru.nikolotov.t1task3.dto.UserDto;
import ru.nikolotov.t1task3.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDto> entitiesToDtos(List<User> entities);

    User dtoToEntity(CreateUserDto userDto);

    UserDto entityToDto(User userDto);

    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "id", ignore = true)
    User updateEntity(@MappingTarget User entity, CreateUserDto dto);
}
