package ru.nikolotov.t1task3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nikolotov.t1task3.dto.CreateUserDto;
import ru.nikolotov.t1task3.dto.UserDto;
import ru.nikolotov.t1task3.entity.User;
import ru.nikolotov.t1task3.mapper.UserMapper;
import ru.nikolotov.t1task3.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(path = "/{id}")
    public UserDto get(@PathVariable UUID id) {
        User user = userService.get(id);
        return userMapper.entityToDto(user);
    }
    @GetMapping
    public List<UserDto> getAll() {
        return userMapper.entitiesToDtos(userService.getAll());
    }

    @PostMapping
    public UserDto create(@RequestBody CreateUserDto userDto) {
        return userMapper.entityToDto(
                userService.create(userDto));
    }

    @PutMapping(path = "/{id}")
    public UserDto update(@PathVariable UUID id, @RequestBody CreateUserDto userDto) {
        return userMapper.entityToDto(
                userService.update(id, userDto));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}
