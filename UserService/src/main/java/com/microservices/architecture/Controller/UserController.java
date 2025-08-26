package com.microservices.architecture.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.architecture.Entities.User;
import com.microservices.architecture.Service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/")
@Slf4j
public class UserController {

    private final UserService service;

    private int retryCount = 1;

    public UserController(UserService userService){
       this.service = userService;
    }
     
   
    //create User
    @PostMapping("createUser")    
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.saveUser(user);
        return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);  

    }


    // get user by Id
    @GetMapping("{userId}") 
    // @CircuitBreaker(name = "ratingUserBreaker",fallbackMethod = "getUserByIdFallback")  
    @Retry(name="ratingUserService" ,fallbackMethod ="getUserByIdFallback") 
    public ResponseEntity<User> getUserById(@PathVariable("userId") String id){
        System.out.println("Retry count " + retryCount);
        retryCount++;
        User userFromDb = service.findUserById(id);
        return new ResponseEntity<User>(userFromDb,HttpStatus.OK);  

    }


    public ResponseEntity<User> getUserByIdFallback(String id , Exception ex){
        log.error("Exception occured fallback is getting implemented : {}", ex.getMessage());
        User user = User.builder().name("dummy").email("dummy123@gmail.com").userId("DUMMY").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    // get list of all users
     @GetMapping("users")    
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
