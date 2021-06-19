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

    public float returnAverage(int nOfDays, String nOfCurrency){
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + nOfCurrency + "/last/" + nOfDays + "/?format=json\"";
        Root result = restTemplate.getForObject(url, Root.class);
        float average = 0;
        for(Rate r: result.rates){
            average += r.mid;
        }
        average/=nOfDays;
        return average;
    }
}
