package com.keresman.utilities;

public class HtmlUtils {

    private static final String REGEX_HTML_TAGS = "<[^>]*>";
    private static final String REGEX_HTML_ENTITIES = "&[^;]+;";

    private HtmlUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static String stripHtml(String input) {
        return input.replaceAll(REGEX_HTML_TAGS, "")
                .replaceAll(REGEX_HTML_ENTITIES, "")
                .trim();
    }
}
