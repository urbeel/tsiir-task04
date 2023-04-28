package by.urbel.task04.service;

import by.urbel.task04.dto.AdminDto;
import by.urbel.task04.dto.LoginRequest;
import by.urbel.task04.dto.LoginResponse;
import by.urbel.task04.dto.SignUpRequest;
import by.urbel.task04.entity.Cart;
import by.urbel.task04.entity.User;
import by.urbel.task04.entity.enums.Role;
import by.urbel.task04.mapper.UserMapper;
import by.urbel.task04.repository.CartRepository;
import by.urbel.task04.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void register(SignUpRequest signUpRequest) {
        User user = userMapper.convert(signUpRequest);
        user.setRole(Role.ROLE_CUSTOMER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setTotalPrice(0L);
        user.setCart(cart);
        cartRepository.save(cart);
    }


    public void createAdmin(AdminDto dto) {
        User user = userMapper.convert(dto);
        user.setRole(Role.ROLE_ADMIN);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
    }

    public LoginResponse authorize(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getEmail(), loginRequest.getPassword()
                        )
                );
        User user = (User) authenticate.getPrincipal();
        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}
