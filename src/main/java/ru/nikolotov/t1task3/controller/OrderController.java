package ru.nikolotov.t1task3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nikolotov.t1task3.dto.CreateOrderDto;
import ru.nikolotov.t1task3.dto.CreateUserDto;
import ru.nikolotov.t1task3.dto.OrderDto;
import ru.nikolotov.t1task3.dto.UserDto;
import ru.nikolotov.t1task3.entity.Order;
import ru.nikolotov.t1task3.entity.User;
import ru.nikolotov.t1task3.mapper.OrderMapper;
import ru.nikolotov.t1task3.mapper.UserMapper;
import ru.nikolotov.t1task3.service.OrderService;
import ru.nikolotov.t1task3.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping(path = "/{id}")
    public OrderDto get(@PathVariable UUID id) {
        Order order = orderService.get(id);
        return orderMapper.entityToDto(order);
    }
    @GetMapping
    public List<OrderDto> getAll() {
        return orderMapper.entitiesToDto(orderService.getAll());
    }

    @PostMapping
    public OrderDto create(@RequestBody CreateOrderDto orderDto) {
        return orderMapper.entityToDto(
                orderService.create(orderDto));
    }

    @PutMapping(path = "/{id}")
    public OrderDto update(@PathVariable UUID id, @RequestBody CreateOrderDto orderDto) {
        return orderMapper.entityToDto(
                orderService.update(id, orderDto));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable UUID id) {
        orderService.delete(id);
    }
}
