package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Rating;
import com.example.demo.Repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
    
    @Autowired
    private RatingRepository repository;

    @Override
    public Rating saveRating(Rating rating) {
       return repository.save(rating);
    }

    @Override
    public Rating findRatingById(Integer id) {
       return repository.findById(id).get();
    }

    @Override
    public List<Rating> getAllRatings() {
       return repository.findAll();
    }

}
