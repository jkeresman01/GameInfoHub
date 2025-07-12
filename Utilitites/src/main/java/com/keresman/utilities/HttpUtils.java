package com.keresman.utilities;

import com.keresman.factory.URLConnectionFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public final class HttpUtils {

  private static final String CHARSET = StandardCharsets.UTF_8.name();
  private static final String PARAM_QUERY = "query=";

  private HttpUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static String sendSparqlRequest(String endpoint, String sparqlQuery) throws IOException {
    HttpURLConnection connection = URLConnectionFactory.getPostSparqlConnection(endpoint);

    writeQueryToConnection(connection, sparqlQuery);
    checkResponseCode(connection);
    return readResponse(connection);
  }

  private static void writeQueryToConnection(HttpURLConnection connection, String sparqlQuery)
      throws IOException {
    String encodedQuery = PARAM_QUERY + URLEncoder.encode(sparqlQuery, CHARSET);
    try (OutputStream os = connection.getOutputStream()) {
      os.write(encodedQuery.getBytes(StandardCharsets.UTF_8));
    }
  }

  private static void checkResponseCode(HttpURLConnection connection) throws IOException {
    int responseCode = connection.getResponseCode();
    if (responseCode != HttpURLConnection.HTTP_OK) {
      throw new IOException("HTTP error code: " + responseCode);
    }
  }

  private static String readResponse(HttpURLConnection connection) throws IOException {
    try (BufferedReader in =
        new BufferedReader(
            new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
      return in.lines().collect(Collectors.joining("\n"));
    }
  }
}
