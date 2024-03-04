FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/C322-Spring2024-lab2-1.0-SNAPSHOT.jar c322-spring2024-lab2.jar
ENTRYPOINT ["java", "-jar", "c322-spring2024-lab2.jar"]