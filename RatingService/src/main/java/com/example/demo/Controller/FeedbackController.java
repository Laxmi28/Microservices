package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feeback")
public class FeedbackController {
    
    @GetMapping
    private String getFeedback(){
        return "This is just a general feedback for testing API gateway with multiple API in a single service";
    }

}
