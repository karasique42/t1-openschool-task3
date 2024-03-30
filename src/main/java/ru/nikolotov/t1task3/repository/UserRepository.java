package ru.nikolotov.t1task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nikolotov.t1task3.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
