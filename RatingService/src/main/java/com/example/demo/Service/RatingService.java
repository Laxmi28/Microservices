package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Rating;

public interface RatingService {
     
    Rating saveRating(Rating rating);
    Rating findRatingById(String id);
    List<Rating> findRatingByUserId(String userId);
    List<Rating> getAllRatings();
    


    
} 
