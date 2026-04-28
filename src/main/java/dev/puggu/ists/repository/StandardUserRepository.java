package dev.puggu.ists.repository;

import dev.puggu.ists.entity.Users.StandardUser;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StandardUserRepository extends JpaRepository<StandardUser, UUID> {
    boolean existsByEmail(String email);
    Optional<StandardUser> findByEmail(String email);

    @NonNull
    Optional<StandardUser> findById(@NonNull UUID id);
}
