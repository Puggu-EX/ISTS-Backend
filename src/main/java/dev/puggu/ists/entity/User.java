package dev.puggu.ists.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

    @Id
    @UuidGenerator
    @Nonnull
    @Column(name = "user_id")
    private UUID userID;

    @Nonnull
    private String firstName;

    @Nonnull
    private String lastName;

    @Nonnull
    private String email;

    @Nonnull
    private String password;

    @Nonnull
    private String status;
}
