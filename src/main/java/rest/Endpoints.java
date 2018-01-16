package rest;

public class Endpoints {
    public static final String BASE = "https://api.whaleclub.co";
    public static final String VERSION = "/v1";
    public static final String API_TOKEN = "dc296379-92cf-44d2-827a-66a600a2411a";

    public static String getUrl(String method) {
        return BASE + VERSION + method;
    }
}