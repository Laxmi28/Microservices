package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Rating;
import com.example.demo.Service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
    
    @Autowired
    private RatingService ratingService;
    
    @GetMapping("/createRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
           Rating ratingInDb = ratingService.saveRating(rating);
           return new ResponseEntity<>(ratingInDb,HttpStatus.CREATED);
    }

}
