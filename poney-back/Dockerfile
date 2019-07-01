FROM openjdk:8-jdk-alpine


# Copy to images tomcat path
COPY /target/pnj_generator-0.0.1-SNAPSHOT.war pnj_generator.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "pnj_generator.jar"]