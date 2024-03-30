package ru.nikolotov.t1task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class T1Task3Application {

    public static void main(String[] args) {
        SpringApplication.run(T1Task3Application.class, args);
    }

}
