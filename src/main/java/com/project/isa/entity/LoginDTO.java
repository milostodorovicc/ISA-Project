package com.project.isa.entity;

import jakarta.persistence.Column;

public class LoginDTO {

    private Long id;
    private Uloga uloga;
    private String emailadresa;
    private String lozinka;
    public int logcounter;

    public String getEmailadresa() {
        return emailadresa;
    }

    public void setEmailadresa(String emailadresa) {
        this.emailadresa = emailadresa;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getLogcounter() {
        return logcounter;
    }

    public void setLogcounter(int logcounter) {
        this.logcounter = logcounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public LoginDTO(Long id, Uloga uloga, String emailadresa, String lozinka, int logcounter) {
        this.id = id;
        this.uloga = uloga;
        this.emailadresa = emailadresa;
        this.lozinka = lozinka;
        this.logcounter = logcounter;
    }

    public LoginDTO() {
    }
}
