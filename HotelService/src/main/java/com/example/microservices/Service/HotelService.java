package com.example.microservices.Service;

import java.util.List;

import com.example.microservices.Entity.Hotel;

public interface HotelService {

    Hotel saveHotelData(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(String id);

}
