package com.keresman.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class HttpUtils {

    private HttpUtils() {
    }

    public static String sendSparqlRequest(String endpoint, String sparqlQuery) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(endpoint).openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(3000);
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept", "application/sparql-results+json");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String encodedQuery = "query=" + URLEncoder.encode(sparqlQuery, StandardCharsets.UTF_8);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(encodedQuery.getBytes(StandardCharsets.UTF_8));
        }

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + responseCode);
        }

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            return in.lines().collect(Collectors.joining("\n"));
        }
    }

}
