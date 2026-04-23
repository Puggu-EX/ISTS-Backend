package dev.puggu.ists.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class StandardUser extends User {

//    @OneToMany
//    private Set<Ticket> tickets;
}
