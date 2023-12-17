package com.project.isa.service;

import com.project.isa.entity.EmailRequest;
import com.project.isa.entity.Registrovanikorisnik;

public interface EmailService {
    void sendemail(EmailRequest emailRequest, Registrovanikorisnik sender);
}
