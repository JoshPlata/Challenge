package com.josue.sample.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bitacora_reservaciones")
public class Bitacora {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "guest_first_name")
    private String guestFirstName;
    @Column(name = "guest_last_name")
    private String guestLastName;
    @Column(name = "guest_email")
    private String guestEmail;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

}
