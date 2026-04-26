package dev.puggu.ists.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserRegister(
      @NotBlank String first_name,
      @NotBlank String last_name,
      @NotBlank String email,
      @NotBlank String password
) { }