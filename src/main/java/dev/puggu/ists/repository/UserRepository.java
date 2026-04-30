package dev.puggu.ists.repository;

import dev.puggu.ists.entity.Users.User;
import jakarta.annotation.Nonnull;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    @Nonnull
    Optional<User> findById(@Nonnull UUID id);
}
