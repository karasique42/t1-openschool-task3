package ru.nikolotov.t1task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nikolotov.t1task3.entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
