package dev.puggu.ists.service;

import dev.puggu.ists.controller.dto.request.TicketSubmission;
import dev.puggu.ists.controller.dto.response.GenericResponse;
import dev.puggu.ists.entity.Ticket;
import dev.puggu.ists.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
//    private final StandardUserRepository standardUserRepository;

    public ResponseEntity<?> create(TicketSubmission request){
        // Validate author's UUID
        UUID authorUUID;
        try {
            authorUUID = UUID.fromString(request.author());
        }catch (IllegalArgumentException | AssertionError e){
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "Invalid author UUID");
        }

        // Build ticket
        Ticket ticket = new Ticket();
        ticket.setAuthor(authorUUID);
        ticket.setTitle(request.title());
        ticket.setDetails(request.details());

        ticket.setEscalationLevel(0); // Default to 0 on creation
        ticket.setPriority(request.priority());
        ticket.setStatus("Submitted");

        ticket.setTags("SomeTag"); // Hard-coded for now
        ticket.setDateSubmitted(LocalDate.now(ZoneId.of("America/Los_Angeles")));

        try {
            ticketRepository.save(ticket);
        }catch (IllegalArgumentException | OptimisticLockingFailureException e ){
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "Failed to save ticket");
        }

        return GenericResponse.build(HttpStatus.OK, "Successfully created ticket");
    }
}
