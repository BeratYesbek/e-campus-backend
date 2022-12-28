FROM eclipse-temurin:17-jdk-alpine
ADD build/libs/*.jar ecampusapp.jar
ENTRYPOINT ["java","-jar","ecampusapp.jar"]