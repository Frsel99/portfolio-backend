FROM amazoncorretto:11-alpine-jdk
MAINTAINER Frsel99
COPY portfolio-backend-0.0.1-SNAPSHOT.jar portfolio-backend.jar
ENTRYPOINT ["java", "-jar", "/portfolio-backend.jar"]