##persist-gatling-reports-to-mongodb

### Motivation

Simple java program that will persist gatling test statistic data to mongodb. Intention of this
program is to use as a InitContainer in https://github.com/RHEcosystemAppEng/kogito-benchmark/blob/main/test/open-shift/pod-kogito-gatling-benchmark.yaml

### Configurations ⚙️

Following environment variables are required to set before running program.

| Environment variable        | Description  | Example value  |
| ------------- |:-------------:| :-----|
| `GATLING_BASE_FILE_PATH`      | file path where gatling test results generated. | /Users/jnirosha/kogito-benchmark/test/target/gatling |

### How to run 🏃

1. Set all above mentioned environment variables.
2. execute the program using `java -jar target/persistGatlingReportsToMongodb-1.0-SNAPSHOT.jar`command.