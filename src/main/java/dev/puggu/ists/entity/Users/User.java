package dev.puggu.ists.entity.Users;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

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

    @Nonnull
    private String role;
}
