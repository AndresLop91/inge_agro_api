package com.co.ingeagro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
    @RequestMapping("/api")
    public class ImageController {

        @Value("${upload.path}") // Specify the path to store the image in application.properties
        private String uploadPath;

        @PostMapping("/upload-image")
        public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
            try {
                // Create the upload directory if it doesn't exist
                File uploadDirectory = new File(uploadPath);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();
                }

                // Generate a unique file name to avoid conflicts
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

                // Create the destination file
                File destinationFile = new File(uploadDirectory, fileName);

                // Transfer the file to the destination
                file.transferTo(destinationFile);

                // Return a response indicating the success of the upload
                return ResponseEntity.ok("Image uploaded successfully");
            } catch (IOException e) {
                // Handle the exception and return an error response
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
            }
        }
    }

