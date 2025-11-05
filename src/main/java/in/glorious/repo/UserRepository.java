package in.glorious.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.glorious.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}