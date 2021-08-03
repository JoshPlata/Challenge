package com.josue.sample.Service;

import com.josue.sample.DTO.Response.SimpleResponse;
import com.josue.sample.DTO.RoomDto;
import com.josue.sample.Entity.Hotel;
import com.josue.sample.Entity.Room;
import com.josue.sample.Entity.RoomType;
import com.josue.sample.Repository.HotelRepository;
import com.josue.sample.Repository.RoomRepository;
import com.josue.sample.Repository.RoomTypeRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@CommonsLog
@Service
public class RoomService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    public RoomService(){}

    public SimpleResponse addRoom(RoomDto roomDto){
        SimpleResponse response = new SimpleResponse(false,null);
        try{
            log.info("Adding room");
            Optional<Hotel> hotel = hotelRepository.findById(roomDto.getHotelId());
            if (!hotel.isPresent())
                return response;

            Optional<RoomType> roomType = roomTypeRepository.findById(roomDto.getType());
            if(!roomType.isPresent())
                return  response;

            Room room = new Room();
            room.setHotel(hotel.get());
            room.setFloor(roomDto.getFloor());
            room.setType(roomType.get());
            room.setDescription(roomDto.getDescription());
            room.setName(roomDto.getName());
            room.setMaxGuests(roomDto.getMaxGuests());

            roomRepository.save(room);

            return new SimpleResponse(true,null);
        }catch(Exception ex) {
            log.trace(ex);
        }
        return  response;
    }
}
