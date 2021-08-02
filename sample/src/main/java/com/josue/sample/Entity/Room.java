package com.josue.sample.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "hotel")
@ToString
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private int floor;
    private int maxGuests;

    @OneToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private RoomType type;

    @OneToMany(mappedBy = "room", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
