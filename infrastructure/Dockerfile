FROM openjdk:21-alpine
LABEL authors="laurenci"
COPY build/libs/infrastructure-0.0.1-SNAPSHOT.jar project.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "project.jar"]