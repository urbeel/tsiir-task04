package by.urbel.task04.dto;

import by.urbel.task04.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = Messages.EMAIL_NOT_EMPTY)
    private String email;
    @NotBlank(message = Messages.PASSWORD_NOT_EMPTY)
    private String password;
}
