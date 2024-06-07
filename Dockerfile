# syntax = docker/dockerfile:1.2
#
# Build stage
#

FROM maven:3.8.6-openjdk-18 AS build
COPY . .
RUN mvn clean package assembly:single -DskipTests

#
# Package stage
#

FROM openjdk:17-jdk-slim
COPY --from=build /target/TPDDSApp.jar webapp.jar
# ENV PORT=8080
EXPOSE 8080
CMD ["java","-classpath","mockapp.jar","ar.edu.utn.dds.copiame.MockApp.java"]