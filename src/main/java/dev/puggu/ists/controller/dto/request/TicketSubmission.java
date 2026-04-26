package dev.puggu.ists.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record TicketSubmission(
     @NotBlank UUID author,
     @NotBlank  String title,
     @NotBlank  String description,
     @NotBlank  int escalation_level,
     @NotBlank  int priority,
     @NotBlank  String status,
     @NotBlank  String tag,
     @NotBlank  LocalDate date_submitted
) { }
