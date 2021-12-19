package com.my_company.comp.models.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail (String toEmail, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("spring.testpol@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        mailSender.send(message);
    }
}
