package Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTTPStatus {
    private Map<String, List> statuses;

    public HTTPStatus() {
        this.statuses = new HashMap<String, List>();
        this.statuses.put("NOT_FOUND", Arrays.asList("404", "Not Found"));
        this.statuses.put("OK", Arrays.asList("200", "OK"));
        this.statuses.put("INTERNAL_SERVER_ERROR", Arrays.asList("500", "Internal Server Error"));
    }

    public Map<String, List> getStatuses() {
        return statuses;
    }

    public void setStatuses(Map<String, List> statuses) {
        this.statuses = statuses;
    }

    public String getOKCode() {
        return statuses.get("OK").get(0).toString();
    }

    public String getOKStatus() {
        return statuses.get("OK").get(0).toString();
    }

    public String getNotFoundCode() {
        return statuses.get("NOT_FOUND").get(0).toString();
    }

    public String getNotFoundStatus() {
        return statuses.get("NOT_FOUND").get(0).toString();
    }
}
