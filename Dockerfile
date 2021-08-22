FROM quay.io/lrangine/maven:3.8-adoptopenjdk-11 as dev

WORKDIR /usr/app

ENV GATLING_FILE_PATH_ENV=/allevi \
    MONGODB_CONNECTION_URI=mongodb://0.0.0.0:27017 \
    MONGODB_NAME=Kogito_db \
    MONGODB_COLLECTION_NAME=benchmark_results

COPY ./target/persistGatlingReportsToMongodb-1.0.0-jar-with-dependencies.jar .

CMD ["java","-jar","persistGatlingReportsToMongodb-1.0.0-jar-with-dependencies.jar"]