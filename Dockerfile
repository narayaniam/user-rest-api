FROM openjdk:17-jdk-alpine

COPY target/user-rest-api-0.0.1-SNAPSHOT.jar user-rest-api.jar

ENTRYPOINT ["java","-jar","/user-rest-api.jar"]


