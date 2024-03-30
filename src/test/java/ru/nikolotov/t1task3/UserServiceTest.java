package ru.nikolotov.t1task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nikolotov.t1task3.dto.CreateUserDto;
import ru.nikolotov.t1task3.entity.User;
import ru.nikolotov.t1task3.service.UserService;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
public class UserServiceTest extends AbstractTest {

    @Autowired
    private UserService userService;

    @Test
    public void whenUserNotFoundWhileGetting_thenReturnEntity() {
        when(userRepository.findById(any()))
                .thenReturn(Optional.of(new User()));
        Assertions.assertNotNull(userService.get(UUID.randomUUID()));
    }

    @Test
    public void whenUserNotFoundWhileGetting_thenThrowsException() {
        when(userRepository.findById(any()))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class, () -> userService.get(UUID.randomUUID()), "No value present");
    }

    @Test
    public void whenUserNotFoundWhileUpdating_thenReturnEntity() {
        User user = new User();
        when(userRepository.findById(any()))
                .thenReturn(Optional.of(user));
        when(userRepository.save(any()))
                .thenReturn(user);
        when(userMapper.updateEntity(any(), any()))
                .thenReturn(user);
        Assertions.assertNotNull(userService.update(UUID.randomUUID(), new CreateUserDto()));
    }
}
