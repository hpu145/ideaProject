package com.kaishengit.controller;

import com.kaishengit.pojo.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping("/movie/{id:\\d+}")
    public Movie findById(@PathVariable Integer id) {
        return new Movie(100,"西游记","六小龄童");
    }

}
