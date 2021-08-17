import org.json.simple.JSONObject;

public class SuccessfulRequests extends RequestsGroup {

    public SuccessfulRequests(JSONObject jsonObject) {
        super();

        RequestsGroup requestsGroup1 = new RequestsGroup(jsonObject.get("group1"));
        RequestsGroup requestsGroup2 = new RequestsGroup(jsonObject.get("group2"));
        RequestsGroup requestsGroup3 = new RequestsGroup(jsonObject.get("group3"));


        this.count = requestsGroup1.count + requestsGroup2.count + requestsGroup3.count;
        this.percentage = requestsGroup1.percentage + requestsGroup2.percentage + requestsGroup3.percentage;
    }
}

