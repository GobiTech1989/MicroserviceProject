FROM openjdk:8
ADD target/ChildService.jar ChildService.jar
EXPOSE 4002
ENTRYPOINT ["java", "-jar", "ChildService.jar"]