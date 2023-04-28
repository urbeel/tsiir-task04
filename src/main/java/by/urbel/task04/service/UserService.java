package by.urbel.task04.service;

import by.urbel.task04.constants.Messages;
import by.urbel.task04.dto.UserDto;
import by.urbel.task04.mapper.UserMapper;
import by.urbel.task04.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> readAll() {
        return userMapper.convert(userRepository.findAll());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(Messages.USER_NOT_FOUND, username)));
    }
}
