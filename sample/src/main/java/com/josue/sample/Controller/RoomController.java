package com.josue.sample.Controller;

import com.josue.sample.DTO.HotelDto;
import com.josue.sample.DTO.Response.SimpleResponse;
import com.josue.sample.DTO.RoomDto;
import com.josue.sample.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(
            value = "/addRoom",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json"
    )
    public SimpleResponse addHotel(@RequestBody RoomDto roomDto){
        return roomService.addRoom(roomDto);
    }

}
