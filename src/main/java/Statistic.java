import org.json.simple.JSONObject;

public class Statistic<T> {

    T total;
    T ok;
    T ko;

    public Statistic(Object obj) {
        JSONObject jo = (JSONObject) obj;
        total = (T) jo.get("total");
        ok = (T) jo.get("ok");
        ko = (T) jo.get("ko");
    }
}

// registry.access.redhat.com/ubi8/

/*
        apiVersion: v1
        kind: Pod
        metadata:
        name: sender-app
        labels:
        name: sender-app
        spec:
        containers:
        - name: sender-app
        image: quay.io/ilan_pinto/senderapp*/
