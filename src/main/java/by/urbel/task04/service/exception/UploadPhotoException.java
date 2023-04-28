package by.urbel.task04.service.exception;

import java.io.Serial;

public class UploadPhotoException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -7940828761810899680L;

    public UploadPhotoException(Throwable cause) {
        super(cause);
    }
}
