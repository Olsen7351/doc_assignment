# Use the official OpenJDK 17 image as the base image
FROM openjdk:17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY . .

# Build the Maven project
RUN ./mvnw clean package -DskipTests

# Stage 2: Use a smaller base image for the runtime image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/01_assignmentbackend-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Define the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
