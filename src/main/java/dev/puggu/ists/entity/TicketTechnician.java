package dev.puggu.ists.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TicketTechnician {

    @EmbeddedId
    private TicketTechnicianKey ticketTechnicianKey;

    @ManyToOne
    @MapsId("technicianID")
    @JoinColumn(name="technician_id")
    private Technician technician;

    @ManyToOne
    @MapsId("ticketID")
    @JoinColumn(name="ticket_id")
    private Ticket ticket;

}
