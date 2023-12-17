package com.project.isa.controller;

import com.project.isa.entity.EmailRequest;
import com.project.isa.entity.Registrovanikorisnik;
import com.project.isa.service.AdministratorsistemaService;
import com.project.isa.service.EmailService;
import com.project.isa.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class EmailController {




    private final AdministratorsistemaService administratorsistemaService;
    private final  EmailService emailService;
    public EmailController(AdministratorsistemaService administratorsistemaService, EmailService emailService){
        this.administratorsistemaService = administratorsistemaService;
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {

        try {

            Long l = Long.parseLong(emailRequest.getIdsender());
            Registrovanikorisnik sender = administratorsistemaService.findOne(l);
            emailService.sendemail(emailRequest, sender);

            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }

    }






}
