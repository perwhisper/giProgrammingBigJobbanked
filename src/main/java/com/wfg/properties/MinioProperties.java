package com.wfg.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "wfg.minio")
public class MinioProperties {

    private String endpointUrl;
    private String accessKey;
    private String secreKey;
    private String bucketName;

    @Override
    public String toString() {
        return "MinioProperties{" +
                "endpointUrl='" + endpointUrl + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", secreKey='" + secreKey + '\'' +
                ", bucketName='" + bucketName + '\'' +
                '}';
    }

    public MinioProperties() {
    }

    public MinioProperties(String endpointUrl, String accessKey, String secreKey, String bucketName) {
        this.endpointUrl = endpointUrl;
        this.accessKey = accessKey;
        this.secreKey = secreKey;
        this.bucketName = bucketName;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecreKey() {
        return secreKey;
    }

    public void setSecreKey(String secreKey) {
        this.secreKey = secreKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

}
