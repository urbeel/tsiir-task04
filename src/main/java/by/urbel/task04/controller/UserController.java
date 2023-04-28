package by.urbel.task04.controller;

import by.urbel.task04.controller.constants.Routes;
import by.urbel.task04.dto.UserDto;
import by.urbel.task04.entity.enums.Role;
import by.urbel.task04.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Routes.USERS)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @Secured(Role.Constants.ADMIN_ROLE)
    public List<UserDto> readAll() {
        return userService.readAll();
    }
}
