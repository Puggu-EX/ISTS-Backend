package dev.puggu.ists.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Ticket {

    @Id
    @UuidGenerator
    @Column(name = "ticket_id")
    private UUID ticketID;

    private String title;
    private String description;
    private String level;
    private String status;

    private String author;
}
