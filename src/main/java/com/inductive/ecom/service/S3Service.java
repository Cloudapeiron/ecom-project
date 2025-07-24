package com.inductive.ecom.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

  private final S3Client s3Client;
  private final String bucketName = "your-flask-uploads"; // Replace with your S3 bucket name

  public S3Service() {
    this.s3Client = S3Client.builder()
        .region(Region.US_WEST_1) // Replace with your AWS region
        .credentialsProvider(DefaultCredentialsProvider.create())
        .build();
  }

  public String uploadFile(MultipartFile file) throws IOException {
    String key = System.currentTimeMillis() + "-" + file.getOriginalFilename();

    PutObjectRequest putObjectRequest = PutObjectRequest.builder()
        .bucket(bucketName)
        .key(key)
        .contentType(file.getContentType())
        .build();

    s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));

    return key;
  }
}
