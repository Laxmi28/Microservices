package com.example.microservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.Entity.Hotel;
import com.example.microservices.Service.HotelService;

@RestController
@RequestMapping("/")
public class HotelController {
    
    
    @Autowired
    private HotelService service;

    @PostMapping("createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotelStoredInDb = service.saveHotelData(hotel);
        return new ResponseEntity<>(hotelStoredInDb,HttpStatus.CREATED);
       
    }
    
    @GetMapping("{Id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("Id") String id ){
        Hotel hotelStoredInDb = service.getHotelById(id);
        return ResponseEntity.ok().body(hotelStoredInDb);

    }

     @GetMapping("hotels")
    public ResponseEntity<java.util.List<Hotel>> getAllHotel(){
       java.util.List<Hotel>  hotels = service.getAllHotels(); 
        return ResponseEntity.ok().body(hotels);

    }




}
