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

public class Client {
    private String url;
    private String apiToken;

    private HttpClient client;
    private HttpUriRequest request;
    private HttpResponse response;
    private ResponseHeaders responseHeaders;
    private HttpEntity entity;
    private String jsonResponse;

    public Client(String url, String apiToken) {
        this.url = url;
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
        createGetRequest();
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