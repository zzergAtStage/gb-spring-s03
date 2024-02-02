FROM openjdk:17
COPY /out/artifacts/gb_spring_s03_jar/gb-spring-s03.jar /usr/src/my-app/gb-spring-s03.jar
WORKDIR /usr/src/my-app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gb-spring-s03.jar"]