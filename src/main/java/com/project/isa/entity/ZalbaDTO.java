package com.project.isa.entity;

public class ZalbaDTO {

    private String tekstzalbe;
    private String emailkorisnika;
    private Long idsender;


    public String getTekstzalbe() {
        return tekstzalbe;
    }

    public void setTekstzalbe(String tekstzalbe) {
        this.tekstzalbe = tekstzalbe;
    }

    public String getEmailkorisnika() {
        return emailkorisnika;
    }

    public void setEmailkorisnika(String emailkorisnika) {
        this.emailkorisnika = emailkorisnika;
    }

    public Long getIdsender() {
        return idsender;
    }

    public void setIdsender(Long idsender) {
        this.idsender = idsender;
    }

    public ZalbaDTO(String tekstzalbe, String emailkorisnika, Long idsender) {
        this.tekstzalbe = tekstzalbe;
        this.emailkorisnika = emailkorisnika;
        this.idsender = idsender;
    }

    public ZalbaDTO() {
    }
}
