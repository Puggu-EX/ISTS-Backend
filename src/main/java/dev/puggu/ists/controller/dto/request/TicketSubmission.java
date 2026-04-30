package dev.puggu.ists.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record TicketSubmission(
     @NotBlank String author,
     @NotBlank  String title,
     @NotBlank  String details,
     @PositiveOrZero int priority,
     String tag
) { }
