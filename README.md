# persist-gatling-reports-to-mongodb

### Motivation 💡

Simple java program that will persist gatling test statistic data to mongodb. Intention of this
program is to use as a InitContainer in https://github.com/RHEcosystemAppEng/kogito-benchmark/blob/main/test/open-shift/pod-kogito-gatling-benchmark.yaml

### Configurations ⚙️

Following environment variables are required to set before running program.

| Environment variable        | Description  | Example value  |
| ------------- |:-------------| :-----|
| `GATLING_FILE_PATH_ENV`      | file path where gatling test results generated. | `/Users/jnirosha/kogito-benchmark/test/target/gatling` |
| `MONGODB_CONNECTION_URI`      | connection string to mongodb that will be used to persist gatling results. | `mongodb://127.0.0.0:27017` |
| `MONGODB_NAME`      | mongodb database name | `gatling_results` |
| `MONGODB_COLLECTION_NAME`      | mongodb collection name | `statistic_reports` |

### How to run 🏃

1. Set all above mentioned environment variables.
2. execute the program using `java -jar target/persistGatlingReportsToMongodb-1.0-SNAPSHOT.jar`command.
