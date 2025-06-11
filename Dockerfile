# 在项目根目录创建Dockerfile
FROM openjdk:17-jdk-slim
COPY target/*.jar app.jar
EXPOSE 8080
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/myapp_db?useSSL=false
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=MyRootPass123
ENV MINIO_ENDPOINT=http://minio:9000
ENV MINIO_ACCESS_KEY=minio_admin
ENV MINIO_SECRET_KEY=minio_secret
ENTRYPOINT ["java","-jar","/app.jar"]