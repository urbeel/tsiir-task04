package by.urbel.task04.mapper;

import by.urbel.task04.dto.ItemDto;
import by.urbel.task04.entity.OrderItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ProductMapper.class)
public interface OrderItemMapper {
    @Mapping(target = "itemId.product", source = "product")
    OrderItem convert(ItemDto dto);

    @InheritInverseConfiguration
    ItemDto convert(OrderItem orderItem);

    List<ItemDto> convert(List<OrderItem> orderItems);
}
