package by.urbel.task04.customvalidation;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.entity.enums.OrderStatus;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {
    Class<? extends Enum<OrderStatus>> enumClass();

    String message() default Messages.MUST_BE_ENUM;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
