package com.josue.sample.Controller;

import com.josue.sample.DTO.HotelDto;
import com.josue.sample.DTO.Response.DataResponse;
import com.josue.sample.DTO.Response.SimpleResponse;
import com.josue.sample.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(
            value = "/addHotel",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json"
    )
    public SimpleResponse addHotel(@RequestBody HotelDto hotelDTO){
        return hotelService.addHotel(hotelDTO);
    }

    @RequestMapping(
            value = "/removeHotel",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json"
    )
    public SimpleResponse removeHotel(@RequestBody HotelDto hotelDTO){
        return hotelService.removeHotel(hotelDTO);
    }

    @RequestMapping(
            value = "/listHotel",
            method = RequestMethod.GET,
            produces = "application/json",
            consumes = "application/json"
    )
    public DataResponse<List<HotelDto>> listHotel(){
        return hotelService.listHotel();
    }

    @RequestMapping(
            value = "/updateHotel",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json"
    )
    public SimpleResponse updateHotel(@RequestBody HotelDto hotelDto){
        return hotelService.updateHotel(hotelDto);
    }
}
