package com.example.rentalservice.nbp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NBPservice {

    private final RestTemplate restTemplate;

    public NBPservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


}
