package com.josue.sample.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "guest")
public class Guest {
    @Id
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
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
