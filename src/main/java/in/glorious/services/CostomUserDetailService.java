package in.glorious.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import in.glorious.repo.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CostomUserDetailService implements UserDetailsService{
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + username));
    }
    
}
