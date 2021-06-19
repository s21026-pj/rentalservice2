package com.example.rentalservice.controller;

import com.example.rentalservice.model.Movie;
import com.example.rentalservice.nbp.NBPservice;
import com.example.rentalservice.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RentalController {

    private MovieService movieService;
    private NBPservice nbPservice;

    public RentalController(MovieService movieService, NBPservice nbPservice){
        this.movieService = movieService;
        this.nbPservice = nbPservice;
    }

    @ApiOperation(value = "Find movie by ID", notes = "If you give id you will get movie descrption")
    @GetMapping("/getmovie/{id}")
    public ResponseEntity<Movie> getMovie(@ApiParam(value = "Id of movie", example = "3")@PathVariable int id){
        return movieService.getMovie(id);
    }
    @ApiOperation(value = "Return movie by ID", notes = "If you provide id you will make movie available again ")
    @GetMapping("/returnmovie/{id}")
    public ResponseEntity<Movie> returnMovie(@ApiParam(value = "Id of movie", example = "3")@PathVariable int id){
        return movieService.returnMovie(id);
    }
    @ApiOperation(value = "Return average value of given currency", notes = "If you provide name of currency and number of days you will get average ")
    @GetMapping("/nbp/{currency}")
    @ResponseBody
    public float returnAverage(@ApiParam(value = "Number of days", example = "3", defaultValue = "1")@RequestParam(required = false, defaultValue = "1") int nDays, @PathVariable String currency){
        return nbPservice.returnAverage(nDays,currency);
    }
}
