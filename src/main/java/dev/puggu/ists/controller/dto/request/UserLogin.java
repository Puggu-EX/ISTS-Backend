package dev.puggu.ists.controller.dto.request;

import jakarta.annotation.Nonnull;

public record UserLogin (
        @Nonnull String email,
        @Nonnull String password
        )
{ }
