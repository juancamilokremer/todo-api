FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} todo-api.jar
ENTRYPOINT ["java","-jar","/todo-api.jar"]