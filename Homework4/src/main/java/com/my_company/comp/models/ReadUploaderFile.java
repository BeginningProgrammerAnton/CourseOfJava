package com.my_company.comp.models;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadUploaderFile {

    public void read(String fileName) {
        try {
            File file = new File("src/main/java/"+fileName);

            FileReader fr = new FileReader(file);
            String filePath = "src/main/java/res.txt";
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            line += "\n";
            Files.write(Paths.get(filePath), line.getBytes(), StandardOpenOption.APPEND);
            while (line != null) {
                line = reader.readLine();
                String text = line + "\n";
                try {
                    if (line != null) {
                        Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
