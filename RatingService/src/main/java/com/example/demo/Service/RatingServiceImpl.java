package com.example.demo.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Rating;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
    
    @Autowired
    private RatingRepository repository;

    @Override
    public Rating saveRating(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setId(id);
       return repository.save(rating);
    }

    @Override
    public Rating findRatingById(String id) {
       return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Rating not exists"));
    }

    @Override
    public List<Rating> getAllRatings() {
       return repository.findAll();
    }

    @Override
    public List<Rating> findRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

}
