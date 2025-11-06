package in.glorious.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.access-token-expiration-ms}")
    private Long expiration;

    @SuppressWarnings("deprecation")
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    @SuppressWarnings("deprecation")
    public String extractUsername(String token) {
    return Jwts.parser()
            .setSigningKey(secret)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
        }
}