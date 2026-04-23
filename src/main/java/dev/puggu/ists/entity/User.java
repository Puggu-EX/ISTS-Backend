package dev.puggu.ists.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
public abstract class User {

    @Id
    @UuidGenerator
    @Column(name = "user_id")
    private UUID userID;

    private String firstName;
    private String lastName;

    private String email;
    private String password;
}
