package com.keresman.factory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionFactory {

  private static final int TIMEOUT = 10_000;

  private static final String REQUEST_METHOD_GET = "GET";
  private static final String REQUEST_METHOD_POST = "POST";

  private static final String HEADER_USER_AGENT = "User-Agent";
  private static final String HEADER_ACCEPT = "Accept";
  private static final String HEADER_CONTENT_TYPE = "Content-Type";

  private static final String USER_AGENT_VALUE = "Mozilla/5.0";
  private static final String ACCEPT_SPARQL_JSON = "application/sparql-results+json";
  private static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";

  private URLConnectionFactory() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static HttpURLConnection getHttpUrlConnection(String path)
      throws MalformedURLException, IOException {
    HttpURLConnection connection = (HttpURLConnection) new URL(path).openConnection();
    connection.setConnectTimeout(TIMEOUT);
    connection.setReadTimeout(TIMEOUT);
    connection.setRequestMethod(REQUEST_METHOD_GET);
    connection.addRequestProperty(HEADER_USER_AGENT, USER_AGENT_VALUE);
    return connection;
  }

  public static HttpURLConnection getPostSparqlConnection(String endpoint) throws IOException {
    HttpURLConnection connection = (HttpURLConnection) new URL(endpoint).openConnection();
    connection.setRequestMethod(REQUEST_METHOD_POST);
    connection.setConnectTimeout(TIMEOUT);
    connection.setDoOutput(true);
    connection.setRequestProperty(HEADER_ACCEPT, ACCEPT_SPARQL_JSON);
    connection.setRequestProperty(HEADER_CONTENT_TYPE, CONTENT_TYPE_FORM);
    return connection;
  }
}
