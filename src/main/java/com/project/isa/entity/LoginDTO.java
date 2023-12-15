package com.project.isa.entity;

import jakarta.persistence.Column;

public class LoginDTO {

    @Column
    private String emailadresa;
    @Column
    private String lozinka;

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

    public LoginDTO(String emailadresa, String lozinka)  {
        this.emailadresa = emailadresa;
        this.lozinka = lozinka;
    }

    public LoginDTO() {
    }
}
