FROM quay.io/lrangine/maven:3.8-adoptopenjdk-11 as dev

WORKDIR /usr/app

COPY ./target/persistGatlingReportsToMongodb-1.0.0-jar-with-dependencies.jar .

CMD ["java","-jar","persistGatlingReportsToMongodb-1.0.0-jar-with-dependencies.jar"]