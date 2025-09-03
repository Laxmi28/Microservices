package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @Value("${welcome.message}")
    private String message;

    
    @GetMapping("/")
    public String getMessage(){
      return message;
    }
    
    @PostMapping("/addRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
           Rating ratingInDb = ratingService.saveRating(rating);
           return new ResponseEntity<>(ratingInDb,HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{userId}")
    public ResponseEntity<List<Rating>> getRatingFromUserId(@PathVariable String userId){
        List<Rating> ratingStoredInDb = ratingService.findRatingByUserId(userId);
        return new ResponseEntity<List<Rating>>(ratingStoredInDb, HttpStatus.OK);


    }

}
