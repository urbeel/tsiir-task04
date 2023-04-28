package by.urbel.task04.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private List<String> errors;
}
