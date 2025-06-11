package com.wfg;

import com.wfg.properties.MinioProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = {"com.wfg.mapper"})
@SpringBootApplication
@EnableConfigurationProperties(value = {MinioProperties.class})  // 扫描配置项
public class StudentMsgApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMsgApplication.class, args);
	}

}