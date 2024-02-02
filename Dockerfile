FROM openjdk:latest
VOLUME /tmp
EXPOSE 8080
COPY target/*.jar gb-spring-s03-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/gb-spring-s03-0.0.1-SNAPSHOT.jar"]