package com.example.microservices.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservices.Entity.Hotel;
import com.example.microservices.Exception.ResourceNotFoundException;
import com.example.microservices.Repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotelData(Hotel hotel) {
       hotel.setId(UUID.randomUUID().toString()); 
       return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
         return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
          return hotelRepository.findById(id)
                 .orElseThrow(()-> new ResourceNotFoundException("The hotel with this id doesnot exists!!"));
    }

}
