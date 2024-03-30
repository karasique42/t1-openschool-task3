package ru.nikolotov.t1task3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nikolotov.t1task3.aspect.Logged;
import ru.nikolotov.t1task3.dto.CreateOrderDto;
import ru.nikolotov.t1task3.entity.Order;
import ru.nikolotov.t1task3.entity.User;
import ru.nikolotov.t1task3.mapper.OrderMapper;
import ru.nikolotov.t1task3.repository.OrderRepository;
import ru.nikolotov.t1task3.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    @Logged
    public Order get(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow();
    }

    @Logged
    public Order create(CreateOrderDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow();
        Order order = orderMapper.dtoToEntity(dto);
        order.setUser(user);
        return orderRepository.save(order);
    }

    @Logged
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Logged
    public Order update(UUID id, CreateOrderDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow();
        Order order = orderRepository.findById(id)
                .map(entity -> orderMapper.updateEntity(entity, dto))
                .orElseThrow();
        order.setUser(user);
        return orderRepository.save(order);
    }

    @Logged
    public void delete(UUID id) {
        Order entity = orderRepository.findById(id)
                .orElseThrow();
        orderRepository.delete(entity);
    }
}
