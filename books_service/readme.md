This repository contains the source code for Building a RESTful Web Service with Spring Boot using an H2 in-memory database.
  
Created a docker file with below contecnts:
  From openjdk:8-jdk-alpine
  VOLUME /var/lib/docker/tmp/buildkit-mount831615989
  ADD target/books_service-2.0.0-SNAPSHOT.jar app.jar
  ENTRYPOINT ["java","-jar","/app.jar"]



installed Docker in my local

Used beloow Docker commands :
docker build -t ritesh 
docker image ls
docker run ritesh -p 8080:8080
docker ps -a
