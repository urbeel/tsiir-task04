package by.urbel.task04.service.exception;

import java.io.Serial;

public class InvalidPhotoUrlFormatException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2835426450325667980L;

    public InvalidPhotoUrlFormatException(String message) {
        super(message);
    }
}
