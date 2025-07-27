package com.microservices.architecture.External;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservices.architecture.Entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingClient {
    
     @GetMapping("/rating/{userId}")
     Rating[] getRating(@PathVariable String userId);
     
     @PostMapping("/rating/addRating")
     Rating createRating(Rating rating);
     
     /*
      * similar to create rating we can have put post , delete all together
      */
    
} 
