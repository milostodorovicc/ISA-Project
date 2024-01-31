package com.project.isa.service;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodeService {

    String potvrdirezervaciju(String rezervacija);
}
