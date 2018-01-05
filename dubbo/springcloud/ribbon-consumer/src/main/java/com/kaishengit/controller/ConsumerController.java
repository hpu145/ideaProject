package com.kaishengit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon_consumer")
    public String helloController() {
        return restTemplate.getForEntity("http://HELLO-SERVICE-PROVIDER/hello",
                        String.class).getBody();

    }


}
