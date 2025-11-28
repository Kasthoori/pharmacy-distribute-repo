#------- Stage 1: Build the jar --------
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom and download dependencies (faster incremental builds)
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn -B clean package -DskipTests

#------- Stage 2: runtime image --------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose default port (Can be override)
EXPOSE 8761

ENTRYPOINT [ "java", "-jar", "app.jar" ]