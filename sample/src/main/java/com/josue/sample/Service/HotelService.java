package com.josue.sample.Service;

import com.josue.sample.DTO.HotelDto;
import com.josue.sample.DTO.Response.DataResponse;
import com.josue.sample.DTO.Response.SimpleResponse;
import com.josue.sample.Entity.Hotel;
import com.josue.sample.Entity.Room;
import com.josue.sample.Entity.RoomType;
import com.josue.sample.Repository.HotelRepository;
import com.josue.sample.Repository.RoomRepository;
import com.josue.sample.Repository.RoomTypeRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@CommonsLog
@Service
public class HotelService {

    @Autowired
    private  HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    public HotelService(){}

    public SimpleResponse addHotel(HotelDto hotelDTO){
        SimpleResponse response = new SimpleResponse(false,null);
        try{
            log.info("Adding Hotel");
            Hotel hotel = new Hotel();
            hotel.setDescription(hotelDTO.getDescription());
            hotel.setName(hotelDTO.getName());
            hotel.setStars(hotelDTO.getStars());
            hotelRepository.save(hotel);

            if (Objects.nonNull(hotelDTO.getRooms())){
                log.info("Adding rooms");
                hotelDTO.getRooms().stream()
                        .map(item -> {
                            Optional<RoomType> rt =  roomTypeRepository.findById(item.getType());
                            Room room = new Room();
                            room.setHotel(hotel);
                            room.setDescription(item.getDescription());
                            room.setName(item.getName());
                            room.setFloor(item.getFloor());
                            room.setMaxGuests(item.getMaxGuests());
                            room.setType(Objects.nonNull(rt.get()) ? rt.get() : null);
                            return room;
                        }).forEach(item -> roomRepository.save(item));


            }
            return new SimpleResponse(true,null);
        }catch(Exception ex) {
            log.trace(ex);
        }
        return  response;
    }

    public SimpleResponse removeHotel(HotelDto hotelDto){
        SimpleResponse response = new SimpleResponse(false,null);
        try{
            log.info("Removing Hotel with id: "+ hotelDto.getId());
            Optional<Hotel> _hotel=  hotelRepository.findById(hotelDto.getId());
            if (_hotel.isPresent())
                hotelRepository.delete(_hotel.get());
            return new SimpleResponse(true,null);
        }catch(Exception ex) {
            log.trace(ex);
        }
        return  response;
    }

    public DataResponse<List<HotelDto>> listHotel(){
        DataResponse<List<HotelDto>> response = new DataResponse(null, null,false);
        try{
            log.info("Loading hotels");
            List<Hotel> _hotel=  hotelRepository.findAll();
            if (!_hotel.isEmpty()) {
                List <HotelDto> _list = _hotel.stream().map(item -> {
                    HotelDto hdto = new HotelDto();
                    hdto.setId(item.getId());
                    hdto.setDescription(item.getDescription());
                    hdto.setName(item.getName());
                    hdto.setStars(item.getStars());
                    return hdto;
                }).collect(Collectors.toList());
                return new DataResponse<List<HotelDto>>(_list,null,true);
            }
        }catch(Exception ex) {
            log.trace(ex);
        }
        return  response;
    }

    public SimpleResponse updateHotel(HotelDto hotelDto){
        SimpleResponse response = new SimpleResponse(false,null);
        try{
           log.info("Updating hotel with id: "+ hotelDto.getId());
           Hotel hotel = hotelRepository.getById(hotelDto.getId());
           hotel.setStars(hotelDto.getStars());
           hotel.setDescription(hotelDto.getDescription());
           hotel.setName(hotelDto.getName());

           hotelRepository.save(hotel);

           return new SimpleResponse(true, null);
        }catch(Exception ex) {
            log.trace(ex);
        }
        return  response;
    }

}
