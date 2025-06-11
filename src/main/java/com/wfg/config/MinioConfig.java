package com.wfg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value; // 修复：明确导入 Spring 的 @Value

import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class MinioConfig {

    @Value("${wfg.minio.endpointUrl}")
    private String endpointUrl;
    
    @Value("${wfg.minio.accessKey}")
    private String accessKey;
    
    @Value("${wfg.minio.secreKey}")
    private String secreKey;
    
    @Value("${wfg.minio.bucketName}")
    private String bucketName;
    
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpointUrl)
                .credentials(accessKey, secreKey)
                .build();
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public String getBucketName() {
        return bucketName;
    }
}







