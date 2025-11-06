package in.glorious.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.glorious.dto.LoginRequest;
import in.glorious.dto.RegisterRequest;
import in.glorious.services.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        try {
            authService.createUser(request);
            return "Registered";
        } catch (Exception e) {
            return e.getMessage();
        }
       
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest user) {
         try {
           return ResponseEntity.ok().body(authService.loginUser(user));
         } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND );
         }
    }
}
