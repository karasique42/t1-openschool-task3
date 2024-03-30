package ru.nikolotov.t1task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nikolotov.t1task3.dto.CreateOrderDto;
import ru.nikolotov.t1task3.entity.Order;
import ru.nikolotov.t1task3.entity.User;
import ru.nikolotov.t1task3.service.OrderService;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
public class OrderServiceTest extends AbstractTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void whenUserNotFoundWhileGetting_thenReturnEntity() {
        when(orderRepository.findById(any()))
                .thenReturn(Optional.of(new Order()));
        Assertions.assertNotNull(orderService.get(UUID.randomUUID()));
    }

    @Test
    public void whenUserNotFoundWhileGetting_thenThrowsException() {
        when(orderRepository.findById(any()))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class, () -> orderService.get(UUID.randomUUID()), "No value present");
    }

    @Test
    public void whenUserNotFoundWhileUpdating_thenReturnEntity() {
        Order order = new Order();
        when(userRepository.findById(any()))
                .thenReturn(Optional.of(new User()));
        when(orderRepository.findById(any()))
                .thenReturn(Optional.of(order));
        when(orderRepository.save(any()))
                .thenReturn(order);
        when(orderMapper.updateEntity(any(), any()))
                .thenReturn(order);
        Assertions.assertNotNull(orderService.update(UUID.randomUUID(), new CreateOrderDto()));
    }
}
