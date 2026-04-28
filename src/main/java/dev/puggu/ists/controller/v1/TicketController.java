package dev.puggu.ists.controller.v1;

import dev.puggu.ists.controller.dto.request.TicketSubmission;
import dev.puggu.ists.service.TicketService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/tickets")
@AllArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<?> createTicket(@Valid @RequestBody TicketSubmission ticketSubmission) {
        return ticketService.create(ticketSubmission);
    }
}
