FROM maven:3.8.1-jdk-11 AS build
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/
RUN mvn clean package

FROM openjdk:11
WORKDIR /app
COPY public/product-images public/product-images
COPY --from=build /build/target/bagshop-backend.jar /app
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "bagshop-backend.jar"]