package com.hei.course.endpoint.rest.controller;

import com.hei.course.service.HelloWorldService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {
  //  private final EventProducer<SendEmailRequested> eventProducer;
  //
  //  @GetMapping("/hello")
  //  @SneakyThrows
  //  public String helloWorld(
  //      @RequestParam String to,
  //      @RequestParam String subject,
  //      @RequestParam(defaultValue = "Bonjour,") String salutation,
  //      @RequestParam String body) {
  //    var event =
  //        SendEmailRequested.builder()
  //            .to(to)
  //            .subject(subject)
  //            .salutation(salutation)
  //            .body(body)
  //            .build();
  //    eventProducer.accept(List.of(event));
  //    return "Email sent successfully";
  //  }

  //  @GetMapping("/hello")
  //  public String helloWorld() {
  //    return "... world!";
  //  }

  private final HelloWorldService service;

  @GetMapping("/hello")
  public String helloWorld(@RequestParam String name) {
    return service.uploadHelloWorldMessage(name);
  }
}
