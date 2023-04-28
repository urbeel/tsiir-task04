package by.urbel.task04.controller;

import by.urbel.task04.controller.constants.Routes;
import by.urbel.task04.dto.AdminDto;
import by.urbel.task04.dto.LoginRequest;
import by.urbel.task04.dto.LoginResponse;
import by.urbel.task04.dto.SignUpRequest;
import by.urbel.task04.entity.enums.Role;
import by.urbel.task04.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(Routes.REGISTRATION)
    public void register(@RequestBody @Valid SignUpRequest dto) {
        authService.register(dto);
    }

    @PostMapping(Routes.CREATE_ADMIN)
    @Secured(Role.Constants.ADMIN_ROLE)
    public void createAdmin(@RequestBody @Valid AdminDto dto) {
        authService.createAdmin(dto);
    }

    @PostMapping(Routes.LOGIN)
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.authorize(loginRequest);
    }
}
