package com.wfg.service.impl;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wfg.properties.MinioProperties;
import com.wfg.service.FileUploadService;

import cn.hutool.core.date.DateUtil;
import io.minio.BucketExistsArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.SetBucketPolicyArgs;
import io.minio.StatObjectArgs;
import io.minio.http.Method;



@Service
public class FileUploadServiceImpl implements FileUploadService {



    @Autowired
    private MinioProperties minioProperties;
   
    @Override
    public String fileUpload(MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            // 创建MinIO客户端
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(minioProperties.getEndpointUrl())
                    .credentials(minioProperties.getAccessKey(), minioProperties.getSecreKey())
                    .build();

            String bucketName = minioProperties.getBucketName();
           

            // 检查并创建存储桶
            checkAndCreateBucket(minioClient, bucketName);

            // 生成唯一文件名
            String fileName = generateUniqueFileName(multipartFile);
           

            // 上传文件
            uploadFileToMinIO(minioClient, bucketName, fileName, inputStream, multipartFile);

            // 生成可访问URL（优先使用公开URL，失败则使用签名URL）
            String accessUrl = generateAccessUrl(minioClient, bucketName, fileName);
          
            System.out.println("-----------------");
            System.out.println(accessUrl);
            System.out.println("-----------------");
            return accessUrl;

        } catch (IOException e) {
         
            throw new RuntimeException("文件读取失败：" + e.getMessage(), e);
        } catch (Exception e) {
            
            throw new RuntimeException("文件上传失败：" + e.getMessage(), e);
        }
    }

    /**
     * 检查存储桶并在不存在时创建
     */
    private void checkAndCreateBucket(MinioClient minioClient, String bucketName) throws Exception {
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder()
                .bucket(bucketName)
                .build());
        
        if (!exists) {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
     
            
            // 设置桶为公开可读
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
                    .bucket(bucketName)
                    .config("{\n" +
                            "  \"Version\": \"2012-10-17\",\n" +
                            "  \"Statement\": [{\n" +
                            "    \"Effect\": \"Allow\",\n" +
                            "    \"Principal\": {\"AWS\": [\"*\"]},\n" +
                            "    \"Action\": [\"s3:GetObject\"],\n" +
                            "    \"Resource\": [\"arn:aws:s3:::" + bucketName + "/*\"]\n" +
                            "  }]\n" +
                            "}")
                    .build());
      
        }
    }

    /**
     * 生成唯一文件名（按日期+UUID格式）
     */
    private String generateUniqueFileName(MultipartFile file) {
        String dateDir = DateUtil.format(new Date(), "yyyyMMdd");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = file.getOriginalFilename();
        return dateDir + "/" + uuid + originalFilename;
    }

    /**
     * 上传文件到MinIO
     */
    private void uploadFileToMinIO(MinioClient minioClient, String bucketName, String fileName, 
                                  InputStream inputStream, MultipartFile file) throws Exception {
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .stream(inputStream, file.getSize(), -1)
                .contentType(file.getContentType())
                .build());
      
    }

    /**
     * 生成可访问的URL（优先使用公开URL，失败则使用签名URL）
     */
    private String generateAccessUrl(MinioClient minioClient, String bucketName, String fileName) throws Exception {
        String endpointUrl = minioProperties.getEndpointUrl();
        String publicUrl = endpointUrl + "/" + bucketName + "/" + fileName;
        
        try {
            // 验证公开URL是否可访问
            minioClient.statObject(StatObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .build());
      
            return publicUrl;
        } catch (Exception e) {
        
            // 生成带签名的临时URL（有效期1小时）
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .method(Method.GET)
                    .expiry(3600)
                    .build());
        }
    }
}