package com.project.isa.service;

import com.project.isa.entity.EmailRequest;
import com.project.isa.entity.Registrovanikorisnik;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

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


    public void sendEmailWithAttachment(String recipientEmail, String subject, String qrCodeDataURL) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();

        // Enable multipart messages
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("your-email@example.com");
        helper.setTo(recipientEmail);
        helper.setSubject(subject);

        // Convert data URL to byte array
        byte[] qrCodeBytes = Base64.getDecoder().decode(qrCodeDataURL.split(",")[1]);

        // Attach QR code
        helper.addAttachment("qr_code.png", new ByteArrayResource(qrCodeBytes));

        javaMailSender.send(message);
    }







}
