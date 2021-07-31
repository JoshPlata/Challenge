package com.josue.sample.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private int floor;
    private int maxGuests;
    @OneToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private RoomType type;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
