package by.urbel.task04.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expired}")
    private long validityInMilliseconds;

    public String generateToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String validateTokenAndGetEmail(String token) {
        return JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token).getSubject();
    }
}
