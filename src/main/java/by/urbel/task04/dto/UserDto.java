package by.urbel.task04.dto;

import by.urbel.task04.entity.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends DtoWithId {
    private String email;
    private String firstname;
    private String lastname;
    private Role role;
    private String phone;
    private String address;
}
