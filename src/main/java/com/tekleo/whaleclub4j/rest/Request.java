package com.tekleo.whaleclub4j.rest;

import com.tekleo.whaleclub4j.core.Client;

import java.util.List;
import java.util.Map;

public interface Request {
    public abstract Type getType();

    public abstract String getMethod();

    public abstract List<String> getArguments();

    public abstract Map<String, String> getParameters();

    default String getUrl() {
        // Get base url
        String url = Endpoints.getUrl(getMethod());

        // If there are any arguments
        if (getArguments() != null && !getArguments().isEmpty()) {
            url += "/";
            for (String argument : getArguments())
                url += argument + ",";
            url = url.substring(0, url.length() - 1);
        }

        // If there are any parameters and it's a get request
        if (getParameters() != null && !getParameters().isEmpty() && getType() == Type.GET) {
            url += "?";
            for (Map.Entry<String, String> parameter : getParameters().entrySet())
                url += parameter.getKey() + "=" + parameter.getValue() + "&";
            url = url.substring(0, url.length() - 1);
        }

        return url;
    }

    default String send() {
        Client client = new Client(getType(), getUrl(), getParameters(), Endpoints.API_TOKEN);
        return client.send();
    }

    public static enum Type {
        GET, POST, PUT;
    }
}