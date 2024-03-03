FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/C322-Spring2024-lab2-1.0-SNAPSHOT.jar guitar-management.jar
ENTRYPOINT ["java", "-jar", "guitar-management.jar"]