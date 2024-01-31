package com.project.isa.entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;


public class EmailRequest {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private String idsender;
    private LocalDateTime poctermina;
    private LocalDateTime krajtermina;
    private MultipartFile attachment;

    public void ailSender(){
}

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIdsender() {
        return idsender;
    }

    public void setIdsender(String idsender) {
        this.idsender = idsender;
    }

    public LocalDateTime getPoctermina() {
        return poctermina;
    }

    public void setPoctermina(LocalDateTime poctermina) {
        this.poctermina = poctermina;
    }

    public LocalDateTime getKrajtermina() {
        return krajtermina;
    }

    public void setKrajtermina(LocalDateTime krajtermina) {
        this.krajtermina = krajtermina;
    }
}
