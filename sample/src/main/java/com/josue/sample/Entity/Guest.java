package com.josue.sample.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "guest")
public class Guest {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @OneToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private GuestType type;

    @OneToMany(mappedBy = "guest", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Reservation> reservations;
}
