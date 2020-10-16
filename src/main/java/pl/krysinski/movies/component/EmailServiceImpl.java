package pl.krysinski.movies.component;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmailServiceImpl {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @After("@annotation(PostAspect)")
    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("test@test.com");
        message.setTo("97a8ea6408-07983e@inbox.mailtrap.io");
        message.setSubject("New movie added");
        message.setText("New movie - info");
        emailSender.send(message);
    }
}
