package by.urbel.task04.dto;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.customvalidation.IdNotNull;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ItemDto {
    @NotNull(message = Messages.PRODUCT_NOT_NULL)
    @IdNotNull(message = Messages.PRODUCT_ID_NOT_NULL)
    private ProductDto product;
    @Positive(message = Messages.ITEM_POSITIVE_QUANTITY)
    private int quantity;
}
