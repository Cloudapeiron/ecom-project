package com.inductive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.lambda.LambdaClient;

@Configuration
public class AwsConfig {

  private final Region region = Region.US_WEST_1; // your AWS region

  @Bean
  public S3Client s3Client() {
    return S3Client.builder()
        .region(region)
        .credentialsProvider(DefaultCredentialsProvider.create())
        .serviceConfiguration(S3Configuration.builder().build())
        .build();
  }

  @Bean
  public SsmClient ssmClient() {
    return SsmClient.builder()
        .region(region)
        .credentialsProvider(DefaultCredentialsProvider.create())
        .build();
  }

  @Bean
  public DynamoDbClient dynamoDbClient() {
    return DynamoDbClient.builder()
        .region(region)
        .credentialsProvider(DefaultCredentialsProvider.create())
        .build();
  }

  @Bean
  public LambdaClient lambdaClient() {
    return LambdaClient.builder()
        .region(region)
        .credentialsProvider(DefaultCredentialsProvider.create())
        .build();
  }
}
