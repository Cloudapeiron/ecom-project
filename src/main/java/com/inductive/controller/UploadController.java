package com.inductive.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.inductive.ecom.service.S3Service;

@RestController
@RequestMapping("/api")
public class UploadController {

  private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

  private final S3Service s3Service;

  public UploadController(S3Service s3Service) {
    this.s3Service = s3Service;
  }

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    try {
      String keyName = s3Service.uploadFile(file); // get the real S3 key
      return ResponseEntity.ok("File uploaded successfully: " + keyName);
    } catch (Exception e) {
      logger.error("File upload failed", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("File upload failed: " + e.getMessage());
    }
  }
}
