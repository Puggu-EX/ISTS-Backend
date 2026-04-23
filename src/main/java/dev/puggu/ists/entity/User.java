package dev.puggu.ists.entity;

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
    @NonNull
    @Column(name = "user_id")
    private UUID userID;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    @NonNull
    private String email;
    @NonNull
    private String password;
}
