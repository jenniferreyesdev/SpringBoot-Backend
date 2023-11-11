package com.fintellects.finAPI.controllers;

import com.fintellects.finAPI.services.ImagePostService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class ImagePostController {
    private ImagePostService imagePostService;

    public ImagePostController(ImagePostService imagePostService) {
        this.imagePostService=imagePostService;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.imagePostService.uploadFile(file);
    }
}
