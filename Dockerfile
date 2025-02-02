FROM openjdk:17-jdk-alpine
COPY service/target/service_stub-1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]