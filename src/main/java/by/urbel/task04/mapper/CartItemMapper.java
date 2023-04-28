package by.urbel.task04.mapper;

import by.urbel.task04.dto.ItemDto;
import by.urbel.task04.entity.CartItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ProductMapper.class)
public interface CartItemMapper {
    @Mapping(target = "itemId.product", source = "product")
    CartItem convert(ItemDto dto);

    @InheritInverseConfiguration
    ItemDto convert(CartItem cartItem);

    List<ItemDto> convert(List<CartItem> cartItems);
}
