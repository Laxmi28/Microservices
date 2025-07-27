package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rating_tb_Rating")
public class Rating {
    
    @Id
    private String id;
    private int rating;
    private String feedback;
    private String hotelId;
    private String userId;

}
