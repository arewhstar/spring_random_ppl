# Stage 1: Build the application
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew

# Copy the source code
COPY src/ src/

# Build the project
RUN ./gradlew clean bootJar --no-daemon

# Stage 2: Run the application
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]