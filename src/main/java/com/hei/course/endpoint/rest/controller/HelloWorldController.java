 package com.hei.course.endpoint.rest.controller;

 import com.hei.course.endpoint.event.EventProducer;
 import com.hei.course.endpoint.event.model.SendEmailRequested;
 import java.util.List;
 import lombok.AllArgsConstructor;
 import lombok.SneakyThrows;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;

 @RestController
 @AllArgsConstructor
 public class HelloWorldController {
  private final EventProducer<SendEmailRequested> eventProducer;

  @GetMapping("/hello")
  @SneakyThrows
  public String helloWorld(
      @RequestParam String to,
      @RequestParam String subject,
      @RequestParam(defaultValue = "Bonjour,") String salutation,
      @RequestParam String body) {
    var event =
        SendEmailRequested.builder()
            .to(to)
            .subject(subject)
            .salutation(salutation)
            .body(body)
            .build();
    eventProducer.accept(List.of(event));
    return "Email sent successfully";
  }
 }
