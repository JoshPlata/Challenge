package com.josue.sample.DTO;

import lombok.Data;

@Data
public class RoomDto {
    private String name;
    private String description;
    private int floor;
    private int maxGuests;
    private Long type;
    private Long hotelId;
}
