package com.project.isa.controller;

import com.google.zxing.WriterException;
import com.project.isa.entity.EmailRequest;
import com.project.isa.service.EmailService;
import com.project.isa.service.QRCodeService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/read")
    public ResponseEntity<String> readQRCode(@RequestParam String qrData) {
        try {
        String  a =   URLDecoder.decode(qrData, "UTF-8");
        qrCodeService.potvrdirezervaciju(a);
        System.out.println(a);
        }
                catch (UnsupportedEncodingException e) {
                throw new AssertionError("Greska!");

            }
        return ResponseEntity.ok("QR Code Data: " + qrData);
    }
}