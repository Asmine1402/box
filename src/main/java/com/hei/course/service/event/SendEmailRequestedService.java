package com.hei.course.service.event;

import com.hei.course.endpoint.event.model.SendEmailRequested;
import com.hei.course.mail.Email;
import com.hei.course.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendEmailRequestedService implements Consumer<SendEmailRequested> {
  private final Mailer mailer;

  @SneakyThrows
  @Override
  public void accept(SendEmailRequested sendEmailRequested) {
    InternetAddress recipientAddress = new InternetAddress(sendEmailRequested.getTo());
    String fullBody = sendEmailRequested.getSalutation() + "\n\n" + sendEmailRequested.getBody();
    mailer.accept(new Email(recipientAddress, List.of(), List.of(), "", "", List.of()));
  }
}
