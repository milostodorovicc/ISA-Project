package com.project.isa.repository;

import com.project.isa.entity.GraniceDTO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class KategorijeRepository {


    private String filePath;

    public KategorijeRepository(String filePath) {
        this.filePath = filePath;
    }

    public void saveStringsToFile(String[] stringsToSave) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String str : stringsToSave) {

                writer.write(str);
                writer.newLine();
            }
            System.out.println("Strings saved to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
