From openjdk:8-jdk-alpine
VOLUME /var/lib/docker/tmp/buildkit-mount831615989
ADD target/books_service-2.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]