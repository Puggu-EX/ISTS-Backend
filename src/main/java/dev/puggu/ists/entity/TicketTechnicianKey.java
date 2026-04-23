package dev.puggu.ists.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter @Setter
public class TicketTechnicianKey implements Serializable {
    @Column(name="technician_id")
    UUID technicianID;

    @Column(name="ticket_id")
    UUID ticketID;
}
