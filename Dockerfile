# === Stage 1: Build Stage ===
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy everything to container
COPY . .

# ✅ Make mvnw executable
RUN chmod +x mvnw

# Build the project (this will generate the JAR)
RUN ./mvnw clean package -DskipTests

# === Stage 2: Run Stage ===
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the built jar from previous stage
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
