package ru.nikolotov.t1task3.dto;

import lombok.Data;
import ru.nikolotov.t1task3.entity.OrderStatus;

import java.util.UUID;

@Data
public class CreateOrderDto {
    private String name;
    private String description;
    private OrderStatus status;
    private UUID userId;
}
