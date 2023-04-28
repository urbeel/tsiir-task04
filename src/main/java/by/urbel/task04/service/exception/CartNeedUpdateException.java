package by.urbel.task04.service.exception;

import java.io.Serial;

public class CartNeedUpdateException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6262705086851326328L;

    public CartNeedUpdateException(String message) {
        super(message);
    }
}
