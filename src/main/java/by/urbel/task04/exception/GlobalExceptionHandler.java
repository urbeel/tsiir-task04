package by.urbel.task04.exception;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.service.exception.CartNeedUpdateException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ErrorMessage authenticationException() {
        ErrorMessage message = new ErrorMessage();
        message.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        message.setMessage(Messages.INCORRECT_EMAIL_PASSWORD);
        message.setTimestamp(new Date());
        return message;
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage constraintViolationException(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage).toList();
        ErrorMessage message = new ErrorMessage();
        message.setStatusCode(HttpStatus.BAD_REQUEST.value());
        message.setTimestamp(new Date());
        message.setErrors(errors);
        return message;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        ErrorMessage message = new ErrorMessage();
        message.setStatusCode(HttpStatus.BAD_REQUEST.value());
        message.setTimestamp(new Date());
        message.setErrors(errors);
        return message;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage entityNotFoundException(EntityNotFoundException ex) {
        ErrorMessage message = new ErrorMessage();
        message.setStatusCode(HttpStatus.NOT_FOUND.value());
        message.setMessage(ex.getMessage());
        message.setTimestamp(new Date());
        return message;
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage entityExistsException(EntityExistsException ex) {
        ErrorMessage message = new ErrorMessage();
        message.setStatusCode(HttpStatus.CONFLICT.value());
        message.setMessage(ex.getMessage());
        message.setTimestamp(new Date());
        return message;
    }

    @ExceptionHandler(CartNeedUpdateException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage cartNeedUpdateException(CartNeedUpdateException ex) {
        ErrorMessage message = new ErrorMessage();
        message.setStatusCode(HttpStatus.CONFLICT.value());
        message.setMessage(ex.getMessage());
        message.setTimestamp(new Date());
        return message;
    }
}
