package com.my_company.comp.models.controllers;


import com.my_company.comp.models.ReadUploaderFile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @GetMapping("/index")
        public String fileUpload() {
            return "uploader";
        }
    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file")MultipartFile file) {
        String fileName = file.getOriginalFilename();

        try {
            file.transferTo(new File("C:\\Users\\antos\\IdeaProjects\\try1\\src\\main\\java\\" + fileName));
            ReadUploaderFile readUploaderFile = new ReadUploaderFile();
            readUploaderFile.read(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("file uploaded successfully");
    }
}
