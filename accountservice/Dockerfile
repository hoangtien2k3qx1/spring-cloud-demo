## base image
FROM openjdk:17
## copy jar from local into docker image
COPY target/accountservice-0.0.1-SNAPSHOT.jar /accountservice-0.0.1-SNAPSHOT.jar
## command line to run jar
ENTRYPOINT ["java", "-jar", "/accountservice-0.0.1-SNAPSHOT.jar"]

