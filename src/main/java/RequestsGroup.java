import org.json.simple.JSONObject;

public class RequestsGroup {
    long count;
    long percentage;

    public RequestsGroup(Object obj) {
        JSONObject jo = (JSONObject) obj;
        this.count = (long) jo.get("count");
        this.percentage = (long) jo.get("percentage");
    }

    public RequestsGroup() {
    }
}

