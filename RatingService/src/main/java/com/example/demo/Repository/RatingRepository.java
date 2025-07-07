package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating , Integer> {

}
