FROM maven:3.6.1-jdk-11-slim AS build

COPY poney-back/src /usr/src/app/src
COPY poney-back/pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jdk-alpine

COPY --from=build /usr/src/app/target/pnj_generator.jar /usr/app/pnj_generator.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/is2.jar"]