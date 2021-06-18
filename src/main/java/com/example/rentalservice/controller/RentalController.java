package com.example.rentalservice.controller;

import com.example.rentalservice.model.Movie;
import com.example.rentalservice.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    private MovieService movieService;

    public RentalController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/getmovie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable int id){
        return movieService.getMovie(id);
    }

    @GetMapping("/returnmovie/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable int id){
        return movieService.returnMovie(id);
    }
}
