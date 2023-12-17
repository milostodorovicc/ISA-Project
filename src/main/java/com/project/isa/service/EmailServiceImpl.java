package com.project.isa.service;

import com.project.isa.entity.EmailRequest;
import com.project.isa.entity.Registrovanikorisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    public void sendemail(EmailRequest emailRequest, Registrovanikorisnik sender){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sender.getEmailadresa());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());


        message.setFrom(env.getProperty("spring.mail.username"));


        javaMailSender.send(message);


    }
}
