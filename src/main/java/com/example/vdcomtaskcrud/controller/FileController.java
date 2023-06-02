package com.example.vdcomtaskcrud.controller;

import com.example.vdcomtaskcrud.service.UserCsvDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

    private final UserCsvDataService csvDataService;

    @Autowired
    public FileController(UserCsvDataService csvDataService) {
        this.csvDataService = csvDataService;
    }

    @GetMapping("/load-csv")
    public String newCsv() {
        return "files/upload-form";
    }

    @PostMapping("/upload")
    public String uploadCsv(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "redirect:/upload?error";
        }

        csvDataService.loadCsvData(file);
        return "redirect:/users";

    }
}
