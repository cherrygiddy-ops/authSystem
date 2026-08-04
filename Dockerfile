# Stage 1: Build with Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime with JRE
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/system-0.0.1-SNAPSHOT.jar /app/application.jar

ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=10s \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

CMD ["java", "-jar", "application.jar"]
