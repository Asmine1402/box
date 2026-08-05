package com.hei.course.controller;

import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntierController {
  @GetMapping("/stored_int")
  public Integer getEntier() {

    Random rand = new Random();
    return rand.nextInt(10);
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello Asmine";
  }
}
