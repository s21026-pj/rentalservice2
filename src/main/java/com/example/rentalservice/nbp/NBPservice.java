package com.example.rentalservice.nbp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NBPservice {

    private final RestTemplate restTemplate;

    public NBPservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
