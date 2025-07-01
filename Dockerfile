# syntax=docker/dockerfile:1

FROM openjdk:18-alpine3.13

# Set working directory
WORKDIR /app

# Install required packages (git and bash just in case)
RUN apk update && \
    apk upgrade && \
    apk add --no-cache git bash

# Copy project files into container
COPY . .

# Ensure the Maven wrapper script is executable
RUN chmod +x mvnw

# Build the project
RUN ./mvnw package -DskipTests

# Expose the app port
EXPOSE 8080

CMD ["java", "-jar", "target/utility-0.0.1-SNAPSHOT.jar"]
