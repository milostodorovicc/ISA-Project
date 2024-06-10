package com.project.isa.controller;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.project.isa.entity.RezervacijaDTO;
import com.project.isa.service.AdministratorkompanijeService;
import com.project.isa.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping(value = "/api/qrcode")
public class FileController {


    @Autowired
    private QRCodeService qrCodeService;
    @Autowired
    private AdministratorkompanijeService adminkompanijeService;

    @PostMapping("/upload")
    public RezervacijaDTO handleFileUpload(@RequestParam("files") MultipartFile[] files) throws Exception {
        RezervacijaDTO rez2 = new RezervacijaDTO();

        for (MultipartFile file : files) {
            try {
                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
                BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
                Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
                String qrCodeContents = qrCodeResult.getText();
                System.out.println(qrCodeContents);
                String idrezervacije = qrCodeContents.substring(qrCodeContents.indexOf("id:") + 3, qrCodeContents.indexOf(";idopreme"));
                String idopreme = qrCodeContents.substring(qrCodeContents.indexOf("idopreme:") + 9,qrCodeContents.indexOf(";pocetaktermina"));
//                int i= Integer.parseInt(idopreme);
                List<String> idopremesvi = new ArrayList<>();
//                while (i!=0)
//                {
//                    String idopreme1 = idopreme.substring(0,idopreme.indexOf(","));
//                    idopreme = idopreme.substring(idopreme.indexOf(","))
//                    idopremesvi.add(idopreme1);
//                }

                String[] parts = idopreme.split(",");
                int a = 0;
                while (a<parts.length)
                {
                    idopremesvi.add(parts[a]);
                    System.out.println(parts[a]);
                    a++;
                }


                System.out.println(idrezervacije);
                System.out.println(idopreme);

                String idopreme4 = idopreme;
//                List<String> idopreme1 = Arrays.asList(str.split(","));

                RezervacijaDTO rezervacija = adminkompanijeService.findrezervacija(idrezervacije, idopremesvi);

                rez2.setIdopremesva(rezervacija.getIdopremesva());
                rez2.setPrezimekorisnika(rezervacija.getPrezimekorisnika());
                rez2.setImekorisnika(rezervacija.getImekorisnika());
                rez2.setIdkorisnika(rezervacija.getIdkorisnika());
                rez2.setKrajtermina(rezervacija.getKrajtermina());
                rez2.setPocetaktermina(rezervacija.getPocetaktermina());
                rez2.setIdtermina(rezervacija.getIdtermina());


            } catch (IOException | NotFoundException e) {

                System.out.println("Error: QR code not found or could not be decoded");
            }
        }

        return rez2;
    }






}
