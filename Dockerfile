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
COPY --from=build /target/TPDDSApp.jar mockapp.jar
# ENV PORT=8081
EXPOSE 8081
CMD ["java","-classpath","mockapp.jar","ar.edu.utn.dds.copiame.MockApp"]