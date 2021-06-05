package com.example.rentalservice.service;

import com.example.rentalservice.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    private RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(int id){
        return restTemplate.getForObject("http://localhost:8080/movies/" +id, Movie.class);
    }

}
