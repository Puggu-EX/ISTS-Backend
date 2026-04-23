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
    @NonNull
    private UUID ticketID;

    @NonNull
    private UUID author;

    @NonNull
    private String title;

    @NonNull
    private String description;

    private int escalationLevel; // Also Enum? at least set a min-max
    private int priority;

    @NonNull
    private String status; // Enum?

    @NonNull
    private String tags; // Enum?

    // Required Timeline
    @NonNull
    private LocalDate dateSubmitted;
    private LocalDate dateOpened;
    private LocalDate dateAddressed;
    private LocalDate dateSolved;

}
