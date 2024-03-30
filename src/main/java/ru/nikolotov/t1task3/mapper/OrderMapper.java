package ru.nikolotov.t1task3.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nikolotov.t1task3.dto.CreateOrderDto;
import ru.nikolotov.t1task3.dto.OrderDto;
import ru.nikolotov.t1task3.entity.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderDto> entitiesToDto(List<Order> orders);

    Order dtoToEntity(CreateOrderDto userDto);

    OrderDto entityToDto(Order userDto);

    @Mapping(target = "user", ignore = true)
    Order updateEntity(@MappingTarget Order entity, CreateOrderDto dto);
}
