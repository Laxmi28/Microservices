package com.microservices.architecture.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservices.architecture.Entities.User;
import com.microservices.architecture.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository repository){
        this.userRepository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String userId) {

        Optional<User> op = userRepository.findById(userId);
        if(op.isPresent()){
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
