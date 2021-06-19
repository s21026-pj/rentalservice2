package com.example.rentalservice.service;

import com.example.rentalservice.model.Movie;
import com.example.rentalservice.nbp.Rate;
import com.example.rentalservice.nbp.Root;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Movie> getMovie(int id){
            return restTemplate.getForEntity("http://localhost:8080/movies/" + id, Movie.class);
    }

    public ResponseEntity<Movie> returnMovie(int id){
       return restTemplate.getForEntity("http://localhost:8080/rent/" +id, Movie.class);
    }


}
