package com.hei.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class EntierController {
    @GetMapping("/stored_int")
    public Integer getEntier(){

        Random rand = new Random();
       return rand.nextInt(10);

    }
}
