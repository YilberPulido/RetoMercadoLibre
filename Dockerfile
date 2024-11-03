FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY target/meli-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]