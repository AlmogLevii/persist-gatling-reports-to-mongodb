import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//TODO:
//1. find a way to get the pathToTarget dynamically
//2. add the program to the yaml file that Lokesh created
//3. understand the new task "Upload Gatling Metrics into DB"

public class Main {

    final static String pathToTarget = "//home/allevi/kogitoRepos/kogito-benchmark/test/target/gatling/";

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        try {

            String jsonFileName = getJsonFileName(getSimulationID());
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(jsonFileName));


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

    private static String getSimulationID() throws IOException {
        String lastRunFileName =  pathToTarget + "lastRun.txt";
        Path path = Paths.get(lastRunFileName);

        Scanner scanner = new Scanner(path);

        String line = scanner.nextLine();

        scanner.close();

        return line;
    }

    private static String getJsonFileName(String simulationID) {
        String prefix = pathToTarget;
        String suffix = "/js/global_stats.json";
        return prefix + simulationID + suffix;
    }

}
