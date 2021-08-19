FROM registry.access.redhat.com/ubi8/ubi:8.1

# Install OpenJDK-11
RUN apt-get update && \
    apt-get install -y openjdk-11-jre-headless && \
    apt-get clean;

COPY ./target/persistGatlingReportsToMongodb-1.0.0-SNAPSHOT.jar /usr/app

WORKDIR /usr/app

EXPOSE 8080

CMD ["java","-jar","persistGatlingReportsToMongodb-1.0.0-SNAPSHOT.jar"]