# Use a base Java image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml first to leverage Docker cache
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the app
COPY . .

# Build the app
RUN ./mvnw package -DskipTests

# Expose the port that the app will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/utility-0.0.1-SNAPSHOT.jar"]
