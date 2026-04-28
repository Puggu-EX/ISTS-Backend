package dev.puggu.ists.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @UuidGenerator
    @Column(name = "ticket_id")
    @Setter(AccessLevel.NONE)
    @Nonnull
    private UUID ticketID;

    @Nonnull
    private UUID author;

    @Nonnull
    private String title;

    @Nonnull
    private String description;

    private int escalationLevel; // Also Enum? at least set a min-max
    private int priority;

    @Nonnull
    private String status; // Enum?

    @Nonnull
    private String tags; // Enum?

    // Required Timeline
    @Nonnull
    private LocalDate dateSubmitted;
    private LocalDate dateOpened;
    private LocalDate dateAddressed;
    private LocalDate dateSolved;
}
