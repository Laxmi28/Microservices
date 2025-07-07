package com.microservices.architecture.Service;

import java.util.List;
import com.microservices.architecture.Entities.User;


public interface UserService {

     List<User> getAllUsers();
     User findUserById(String userId);
     User saveUser(User user);
     
} 