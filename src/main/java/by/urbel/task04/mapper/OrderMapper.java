package by.urbel.task04.mapper;

import by.urbel.task04.dto.OrderDto;
import by.urbel.task04.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderItemMapper.class, UserMapper.class})
public interface OrderMapper {
    Order convert(OrderDto dto);

    OrderDto convert(Order order);

    List<OrderDto> convert(List<Order> order);
}
