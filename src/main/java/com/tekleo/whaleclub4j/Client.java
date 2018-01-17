package com.tekleo.whaleclub4j;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.util.MapUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private Request.Type type;
    private String url;
    private Map<String, String> parameters;
    private String apiToken;

    private HttpClient client;
    private HttpUriRequest request;
    private HttpResponse response;
    private ResponseHeaders responseHeaders;
    private HttpEntity entity;
    private String jsonResponse;

    public Client(Request.Type type, String url, Map<String, String> parameters, String apiToken) {
        this.type = type;
        this.url = url;
        this.parameters = parameters;
        this.apiToken = apiToken;
    }

    private void createClient() {
        client = HttpClients.custom().build();
    }

    private void createGetRequest() {
        request = RequestBuilder
                .get()
                .setUri(url)
                .setHeader(HttpHeaders.ACCEPT, "application/json")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiToken)
                .build();
    }

    private void createPostRequest() {
        request = RequestBuilder
                .post()
                .setUri(url)
                .setEntity(MapUtils.toEntity(parameters))
                .setHeader(HttpHeaders.ACCEPT, "application/json")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiToken)
                .build();
    }

    private void createRequest() {
        if (type == Request.Type.GET)
            createGetRequest();
        else if (type == Request.Type.POST)
            createPostRequest();
    }

    private void executeRequest() {
        try {
            response = client.execute(request);
            entity = response.getEntity();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void extractHeaders() {
        responseHeaders = new ResponseHeaders(response.getAllHeaders());
    }

    private void extractJson() {
        try {
            jsonResponse = EntityUtils.toString(entity);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String send() {
        createClient();
        createRequest();
        executeRequest();
        extractHeaders();
        extractJson();
        return getJsonResponse();
    }

    public String getJsonResponse() {
        return jsonResponse;
    }

    private static class ResponseHeaders {
        private String limit;
        private String remaining;
        private String reset;

        public ResponseHeaders(Header[] headers) {
            for (Header header : headers) {
                if (header.getName().equalsIgnoreCase("X-RateLimit-Limit"))
                    limit = header.getValue();
                else if (header.getName().equalsIgnoreCase("X-RateLimit-Remaining"))
                    remaining = header.getValue();
                else if (header.getName().equalsIgnoreCase("X-RateLimit-Reset"))
                    reset = header.getValue();
            }
        }

        @Override
        public String toString() {
            return "Headers: limit=" + limit + ", remaining=" + remaining + ", reset=" + reset;
        }
    }
}