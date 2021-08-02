package com.josue.sample.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode
@ToString
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "check_in")
    private boolean checkIn;
    @Column(name = "check_out")
    private boolean checkOut;
    @OneToMany(mappedBy = "reservation", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Room> room;
    @OneToMany(mappedBy = "reservation", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Guest> guest;}
