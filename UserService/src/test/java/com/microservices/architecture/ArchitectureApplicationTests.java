package com.microservices.architecture;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservices.architecture.Entities.Rating;
import com.microservices.architecture.External.RatingClient;


@SpringBootTest
class ArchitectureApplicationTests {

	@Test
	void contextLoads() {
	}
    
	@Autowired
	private RatingClient ratingClient;

	@Test 
	void createRatingUsingFeignClient(){
       Rating rating = Rating.builder().rating(3)
	   							.userId(null)
								.hotelId(null)
								.feedback("This is just a  test").build();

	  ratingClient.createRating(rating);			
	  System.out.println("Rating test done");				
	}


}
