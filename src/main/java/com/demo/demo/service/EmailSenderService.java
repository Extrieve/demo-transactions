package com.demo.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final Logger logger = LoggerFactory.getLogger(EmailSenderService.class);

    public void sendSimpleEmail(String toEmail, String subject, String emailBody){

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("nicolas.cinera@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(emailBody);

        javaMailSender.send(mailMessage);

        logger.info("Email sent withL " + mailMessage.getSubject());
    }
}
