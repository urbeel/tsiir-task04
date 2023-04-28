package by.urbel.task04.dto;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.customvalidation.IdNotNull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto extends DtoWithId {
    @NotBlank(message = Messages.PRODUCT_NAME_NOT_EMPTY)
    @Size(max = 50, message = Messages.PRODUCT_NAME_SIZE)
    private String name;
    @NotNull(message = Messages.CATEGORY_NOT_NULL)
    @IdNotNull(message = Messages.CATEGORY_ID_NOT_NULL)
    @Valid
    private ProductCategoryDto category;
    @Size(max = 500, message = Messages.PRODUCT_DESCRIPTION_SIZE)
    private String description;
    @Positive(message = Messages.PRODUCT_PRICE_POSITIVE)
    private Long price;
    @PositiveOrZero(message = Messages.PRODUCT_QUANTITY_NOT_NEGATIVE)
    private Integer quantity;
    private String photoUrl;
}
