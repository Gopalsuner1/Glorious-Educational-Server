package in.glorious.services;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.glorious.config.JwtUtils;
import in.glorious.dto.LoginRequest;
import in.glorious.dto.LoginResponse;
import in.glorious.dto.RegisterRequest;
import in.glorious.model.User;
import in.glorious.repo.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    public void createUser(RegisterRequest request) throws Exception {
        String username = request.getUsername().trim().toLowerCase();
        String password = request.getPassword().trim().toLowerCase();
        if (userRepository.existsByUsername(username) ||
                userRepository.existsByUsername(password)) {
            throw new Exception("user already exist");
        }
        userRepository.save(User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .scholar(request.getScholar())
                .role("ROLE_USER")
                .build());
    }

    public String loginUser(LoginRequest request) throws Exception{
            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String token = jwtUtils.generateToken(request.getUsername());
            return token;
    }
}
