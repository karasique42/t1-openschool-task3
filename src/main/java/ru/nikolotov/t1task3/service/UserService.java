package ru.nikolotov.t1task3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nikolotov.t1task3.aspect.Logged;
import ru.nikolotov.t1task3.dto.CreateUserDto;
import ru.nikolotov.t1task3.dto.UserDto;
import ru.nikolotov.t1task3.entity.User;
import ru.nikolotov.t1task3.mapper.UserMapper;
import ru.nikolotov.t1task3.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Logged
    public User get(UUID id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    @Logged
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Logged
    public User create(CreateUserDto dto) {
        return Optional.of(dto)
                .map(userMapper::dtoToEntity)
                .map(userRepository::save)
                .orElseThrow();
    }

    @Logged
    public User update(UUID id, CreateUserDto dto) {
        return userRepository.findById(id)
                .map(entity -> userMapper.updateEntity(entity, dto))
                .map(userRepository::save)
                .orElseThrow();
    }

    @Logged
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
