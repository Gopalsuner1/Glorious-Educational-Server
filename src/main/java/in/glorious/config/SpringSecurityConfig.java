package in.glorious.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @SuppressWarnings("removal")
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                          .csrf(c -> c.disable())
                          .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                          .authorizeHttpRequests(auth -> auth
                                                         .requestMatchers("/public/**","/auth/**").permitAll()
                                                         .requestMatchers("/admin/**").hasRole("ADMIN")
                                                         .anyRequest().authenticated()
                                                          )
                          .build();
    }
}
