package com.josue.sample.DTO;

import lombok.Data;

import java.util.List;

@Data
public class HotelDto {
    private Long id;
    private String name;
    private String description;
    private int stars;
    private List<RoomDto> rooms;
}
