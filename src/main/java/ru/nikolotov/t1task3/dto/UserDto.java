package ru.nikolotov.t1task3.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {

    private UUID id;
    private String name;
    private String email;
}
