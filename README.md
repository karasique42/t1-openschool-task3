# Задание 3


## Сборка и запуск

Для сборки проекта требуется JDK 17. Чтобы собрать приложения необходимо выполнить

> mvn clean install

В корне проекта. После можно развернуть приложения в Docker Compose при помощи

>docker-compose up

Приложение будет доступно на порту 8080

Протестировать API приложения можно в Swagger. Документация к API представлена в Swagger.

> http://localhost:8080/swagger-ui/index.html#/ 

## Логирование

Приложение поддерживает логгирование реализованное через Spring AOP, для того, чтобы подключить логирование достаточно
добавить аннотацию `@Logged` над нужным методом. Важно отметить, что логгируются только вызовы методов из других классов в связи с особенностями AspectJ.

Логгируются следующие события:
- Вызов метода с выводом имени метода, его класса и входящих аргументов
- Возврат из метода с выводом возвращаемого значения
- Выбрасывание исключение с выводом исключения

Примеры вывода логгера:

```
12:07:09.973 [main] INFO  ru.nikolotov.t1task3.aspect.LoggingAspect - Method 'update' of class class ru.nikolotov.t1task3.service.OrderService received args 710e2008-675b-4120-9e2a-286bcc2682bc UUID
CreateOrderDto(name=null, description=null, status=null, userId=null) CreateOrderDto
12:07:10.018 [main] INFO  ru.nikolotov.t1task3.aspect.LoggingAspect - Method 'get' of class class ru.nikolotov.t1task3.service.OrderService thrown exception java.util.NoSuchElementException: No value present
12:07:09.867 [main] INFO  ru.nikolotov.t1task3.aspect.LoggingAspect - Method 'get' of class class ru.nikolotov.t1task3.service.OrderService returned value ru.nikolotov.t1task3.entity.Order@5847010
```

## Тесты

Реализованы простейшие тесты для демонстрации вывода логов. Для проверки достаточно выполнить 

> mvn clean test