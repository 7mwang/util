# syntax=docker/dockerfile:1

FROM eclipse-temurin:24-jdk

# Set working directory
WORKDIR /app

# Install git and bash using apt-get (Debian-based)
RUN apt-get update && \
    apt-get install -y git bash && \
    rm -rf /var/lib/apt/lists/*

# Copy project files into container
COPY . .

# Ensure the Maven wrapper script is executable
RUN chmod +x mvnw

# Build the project
RUN ./mvnw package -DskipTests

# Expose the app port
EXPOSE 8080

# Run the jar (change JAR name if needed)
CMD ["java", "-jar", "target/utility-0.0.1-SNAPSHOT.jar"]
