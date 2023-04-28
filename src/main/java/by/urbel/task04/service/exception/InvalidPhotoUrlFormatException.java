package by.urbel.task04.service.exception;

public class InvalidPhotoUrlFormatException extends RuntimeException {
    public InvalidPhotoUrlFormatException(String message) {
        super(message);
    }
}
