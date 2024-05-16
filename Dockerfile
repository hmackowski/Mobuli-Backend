FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/Mobuli-Backend-0.0.1-SNAPSHOT.jar Mobuli-Backend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "Mobuli-Backend-0.0.1-SNAPSHOT.jar"]