package com.keresman.factory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionFactory {

    private static final int TIMEOUT = 10_000;
    private static final String REQUEST_METHOD = "GET";
    private static final String USER_AGENT = "User-Agent";
    private static final String MOZILLA = "Mozilla/5.0";

    private URLConnectionFactory() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static HttpURLConnection getHttpUrlConnection(String path)
            throws MalformedURLException, IOException {
        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(TIMEOUT);
        con.setReadTimeout(TIMEOUT);
        con.setRequestMethod(REQUEST_METHOD);
        con.addRequestProperty(USER_AGENT, MOZILLA);
        return con;
    }

}
