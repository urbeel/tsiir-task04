package by.urbel.task04.mapper;

import by.urbel.task04.dto.CartDto;
import by.urbel.task04.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CartItemMapper.class)
public interface CartMapper {
    CartDto convert(Cart cart);
}
