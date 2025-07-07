package com.microservices.architecture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.architecture.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
