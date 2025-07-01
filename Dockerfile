# Use a base Java image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app
RUN apk update && apk upgrade && \
    apk add --no-cache git
COPY . /app
RUN ./mvnw package

# Expose the port that the app will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/utility-0.0.1-SNAPSHOT.jar"]
