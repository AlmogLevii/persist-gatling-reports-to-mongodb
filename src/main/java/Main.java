import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//TODO:
//1. find a way to get the pathToTarget dynamically
//2. add the program to the yaml file that Lokesh created
//3. understand the new task "Upload Gatling Metrics into DB"

public class Main {

    public static final String GATLING_FILE_PATH_ENV = "GATLING_BASE_FILE_PATH";
    public static final String gatlingBasePath = getGatlingBasePath();

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader(getStatisticFilePath())) {

            final JSONObject jsonObject = (JSONObject) parser.parse(reader);

            Statistic numberOfRequests = new Statistic(jsonObject.get("numberOfRequests"));
            Statistic minResponseTime = new Statistic(jsonObject.get("minResponseTime"));
            Statistic maxResponseTime = new Statistic(jsonObject.get("maxResponseTime"));
            Statistic meanResponseTime = new Statistic(jsonObject.get("meanResponseTime"));
            Statistic standardDeviation = new Statistic(jsonObject.get("standardDeviation"));
            Statistic percentile50 = new Statistic(jsonObject.get("percentiles1"));
            Statistic percentile575 = new Statistic(jsonObject.get("percentiles2"));
            Statistic percentile95 = new Statistic(jsonObject.get("percentiles3"));
            Statistic percentile99 = new Statistic(jsonObject.get("percentiles4"));
            Statistic meanNumberOfRequestsPerSecond = new Statistic(jsonObject.get("meanNumberOfRequestsPerSecond"));

            RequestsGroup failedRequests = new RequestsGroup(jsonObject.get("group4"));
            SuccessfulRequests successfulRequests = new SuccessfulRequests(jsonObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getGatlingBasePath() {
        String providedPath = System.getenv(GATLING_FILE_PATH_ENV);
        if (providedPath == null) {
            throw new RuntimeException(GATLING_FILE_PATH_ENV + " env is not available.");
        } else if (providedPath.isEmpty()) {
            throw new RuntimeException(GATLING_FILE_PATH_ENV + " env value is empty.");
        } else if (providedPath.endsWith(File.separator)) {
            providedPath = providedPath.substring(0, providedPath.lastIndexOf(File.separator));
        }
        return providedPath;
    }

    private static String getStatisticFilePath() throws IOException {
        String lastRunFilePath = gatlingBasePath + File.separator + "lastRun.txt";

        try (Stream<String> fileContentLines = Files.lines(Paths.get(lastRunFilePath))) {
            final String simulationID = fileContentLines.findFirst()
                    .orElseThrow(() -> new RuntimeException("lastRun.txt file is empty!"));
            final String suffix = "/js/global_stats.json";

            return gatlingBasePath + File.separator + simulationID + suffix;
        }
    }

}
