package ru.nikolotov.t1task3;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.nikolotov.t1task3.mapper.OrderMapper;
import ru.nikolotov.t1task3.mapper.UserMapper;
import ru.nikolotov.t1task3.repository.OrderRepository;
import ru.nikolotov.t1task3.repository.UserRepository;

@SpringBootTest
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
public class AbstractTest {

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserMapper userMapper;

    @MockBean
    OrderMapper orderMapper;

    @MockBean
    OrderRepository orderRepository;
}
