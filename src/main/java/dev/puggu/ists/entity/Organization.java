package dev.puggu.ists.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @UuidGenerator
    @Nonnull
    private UUID id;

    @Nonnull
    private String name;

    @Nonnull
    private String description = "";

    
}