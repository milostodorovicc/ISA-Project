package com.project.isa.service;

import com.project.isa.entity.EmailRequest;
import com.project.isa.entity.Registrovanikorisnik;
import jakarta.mail.MessagingException;

import java.io.IOException;

public interface EmailService {
    void sendemail(EmailRequest emailRequest, Registrovanikorisnik sender);
    void sendEmailWithAttachment(String recipientEmail, String subject, String qrCodeDataURL) throws MessagingException, IOException;
}
