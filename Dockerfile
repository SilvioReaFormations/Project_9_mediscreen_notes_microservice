FROM openjdk:11
ADD target/notes-0.0.1.SNAPSHOT.jar notes-microservice-docker.jar
ENTRYPOINT ["java", "-jar", "notes-microservice-docker.jar"]