package com.example.vdcomtaskcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public String uploadScv(@RequestParam("file")MultipartFile file) {
        if (file.isEmpty())
            return "redirect:/upload";

        try {
            csvDataService.loadCsvData(file);

            return "redirect:/users";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
