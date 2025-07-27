package com.microservices.architecture.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.architecture.Entities.Rating;
import com.microservices.architecture.Entities.User;
import com.microservices.architecture.External.RatingClient;
import com.microservices.architecture.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    private final RatingClient ratingClient;

    public UserServiceImpl(UserRepository repository,RestTemplate restTemplate,RatingClient ratingClient){
        this.userRepository = repository;
        this.restTemplate = restTemplate;
        this.ratingClient = ratingClient;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String userId) {

        Optional<User> op = userRepository.findById(userId);
        if(op.isPresent()){
            /*
             * we need to have rating and hotel information
             * for this purpose we would be calling the rating and hotel service api here using
             * resttemplate
             */

            //  Rating[] rating = restTemplate.getForObject("http://RATING-SERVICE/rating/" + userId, Rating[].class);
             Rating[] rating= ratingClient.getRating(userId);
             List<Rating> ratings = Arrays.asList(rating);
             op.get().setRating(ratings);
            return op.get();
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
       return userRepository.save(user);
    }

}
