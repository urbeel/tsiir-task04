package by.urbel.task04.dto;

import by.urbel.task04.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryDto extends DtoWithId{
    @NotBlank(message = Messages.CATEGORY_NAME_NOT_EMPTY)
    @Size(max = 20, message = Messages.CATEGORY_NAME_SIZE)
    private String name;
}
