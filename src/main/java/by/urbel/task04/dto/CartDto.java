package by.urbel.task04.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CartDto extends DtoWithId {
    private Set<ItemDto> items;
    private long totalPrice;
}
