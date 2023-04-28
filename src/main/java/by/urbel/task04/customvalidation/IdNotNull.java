package by.urbel.task04.customvalidation;

import by.urbel.task04.constants.Messages;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = IdNotNullValidator.class)
public @interface IdNotNull {
    String message() default Messages.ID_NOT_NULL;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
