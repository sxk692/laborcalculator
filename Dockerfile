FROM openjdk:17
RUN pwd && ls
COPY ./target/laborcalculator-0.0.1-SNAPSHOT.jar laborcalculator-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "laborcalculator-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080