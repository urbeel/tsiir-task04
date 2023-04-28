package by.urbel.task04.dto;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.customvalidation.IdNotNull;
import by.urbel.task04.entity.enums.OrderStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
public class OrderDto extends DtoWithId {
    @NotNull(message = Messages.USER_NOT_NULL)
    @IdNotNull(message = Messages.USER_ID_NOT_NULL)
    @Valid
    private UserDto user;
    private OrderStatus status;
    @NotEmpty(message = Messages.ORDER_ITEMS_NOT_EMPTY)
    @Valid
    private Set<ItemDto> items;
    private Timestamp orderTime;
    private long totalPrice;
}
