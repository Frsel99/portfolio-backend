FROM adoptopenjdk/openjdk17:alpine-jre
MAINTAINER Frsel99
COPY target/portfolio-backend-0.0.1-SNAPSHOT.jar portfolio-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/portfolio-backend-0.0.1-SNAPSHOT.jar"]