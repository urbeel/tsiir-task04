package by.urbel.task04.customvalidation;

import by.urbel.task04.dto.DtoWithId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdNotNullValidator implements ConstraintValidator<IdNotNull, DtoWithId> {

    @Override
    public boolean isValid(DtoWithId value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.getId() != null;
    }
}
