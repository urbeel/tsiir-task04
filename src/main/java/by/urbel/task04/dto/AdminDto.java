package by.urbel.task04.dto;

import by.urbel.task04.constants.Messages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    @NotBlank(message = Messages.EMAIL_NOT_EMPTY)
    @Size(max = 60, message = Messages.EMAIL_SIZE)
    @Email(message = Messages.INVALID_EMAIL)
    private String email;
    @NotBlank(message = Messages.PASSWORD_NOT_EMPTY)
    @Size(min = 6, max = 16, message = Messages.PASSWORD_SIZE)
    private String password;
    @NotBlank(message = Messages.FIRSTNAME_NOT_EMPTY)
    @Size(max = 45, message = Messages.FIRSTNAME_SIZE)
    private String firstname;
    @NotBlank(message = Messages.LASTNAME_NOT_EMPTY)
    @Size(max = 45, message = Messages.LASTNAME_SIZE)
    private String lastname;
}
