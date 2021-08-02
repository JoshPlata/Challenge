package com.josue.sample.Entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
