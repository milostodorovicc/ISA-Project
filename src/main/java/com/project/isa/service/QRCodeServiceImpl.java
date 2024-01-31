package com.project.isa.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class QRCodeServiceImpl implements QRCodeService{

    public String potvrdirezervaciju(String rezervacija)  {

       String pocetaktermina1 =  rezervacija.substring(rezervacija.indexOf("\"pocetaktermina\":") + 17 ,rezervacija.indexOf(",\"krajtermina\""));
       String krajtermina1 = rezervacija.substring(rezervacija.indexOf("\"krajtermina\":") + 14,rezervacija.indexOf(",\"idadminakomp\""));
        System.out.println(pocetaktermina1);
        System.out.println(krajtermina1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime pocetaktermina = LocalDateTime.parse(pocetaktermina1, formatter);
        LocalDateTime krajtermina = LocalDateTime.parse(krajtermina1, formatter);
        LocalDateTime trenutnovreme = LocalDateTime.now();

        String idrezervacije = rezervacija.substring(rezervacija.indexOf("id:") + 3,rezervacija.indexOf(";idtermina"));
//        if(trenutnovreme.isAfter(pocetaktermina) & trenutnovreme.isBefore(krajtermina)){
//
//        }
//        else
//        {
//
//        }

//        System.out.println(pocetaktermina);
//        System.out.println(krajtermina);

        return "abc";
    }
}
