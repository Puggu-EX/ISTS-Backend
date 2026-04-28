package dev.puggu.ists.repository;

import dev.puggu.ists.entity.Ticket;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    @Nonnull
    Optional<Ticket> findById(@Nonnull UUID uuid);

    Optional<Ticket> findTicketByAuthor(@Nonnull UUID author);
}
