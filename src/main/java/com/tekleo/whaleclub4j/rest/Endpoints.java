package com.tekleo.whaleclub4j.rest;

public class Endpoints {
    public static final String BASE = "https://api.whaleclub.co";
    public static final String VERSION = "/v1";
    public static String API_TOKEN = "dc296379-92cf-44d2-827a-66a600a2411a";

    public static String getUrl(String method) {
        return BASE + VERSION + method;
    }

    public static void setApiToken(String apiToken) {
        API_TOKEN = apiToken;
    }
}