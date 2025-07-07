package com.microservices.architecture.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.architecture.Entities.User;
import com.microservices.architecture.Service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/")
public class UserController {

    private final UserService service;

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
    public ResponseEntity<User> getUserById(@PathVariable("userId") String id){
        User userFromDb = service.findUserById(id);
        return new ResponseEntity<User>(userFromDb,HttpStatus.OK);  

    }


    // get list of all users
     @GetMapping("users")    
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
