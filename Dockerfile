
FROM maven:3.6.3 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package 

FROM openjdk:17.0.2-jdk
ARG JAR_FILE=restapi-0.0.1-SNAPSHOT.jar
COPY --from=maven /usr/src/app/target/${JAR_FILE}  app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]