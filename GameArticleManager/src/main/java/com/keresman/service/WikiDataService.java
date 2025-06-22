package com.keresman.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keresman.model.Developer;
import com.keresman.model.Genre;
import com.keresman.model.Platform;
import com.keresman.model.Game;
import com.keresman.utilities.HttpUtils;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WikiDataService {

    private static final Logger LOGGER = Logger.getLogger(WikiDataService.class.getName());

    private static final String ENDPOINT = "https://query.wikidata.org/sparql";
    private static final String LANGUAGE = "en";
    private static final String INSTANCE_OF_VIDEO_GAME = "wd:Q7889";
    private static final String FIELD_GENRE = "genreLabel";
    private static final String FIELD_DEVELOPER = "developerLabel";
    private static final String FIELD_PLATFORM = "platformLabel";
    private static final String FIELD_RELEASE_DATE = "pubDate";

    private static final String SPARQL_TEMPLATE = """
        SELECT ?game ?gameLabel ?platformLabel ?developerLabel ?genreLabel ?pubDate WHERE {
          ?game wdt:P31 %s;  # instance of video game
                rdfs:label \"%s\"@%s.

          OPTIONAL { ?game wdt:P136 ?genre. }
          OPTIONAL { ?game wdt:P178 ?developer. }
          OPTIONAL { ?game wdt:P400 ?platform. }
          OPTIONAL { ?game wdt:P577 ?pubDate. }

          SERVICE wikibase:label { bd:serviceParam wikibase:language \"%s\". }
        }
        LIMIT 1
        """;

    private WikiDataService() {
    }

    public static Optional<Game> enrichGameInfo(String gameName) {
        try {
            String query = buildSparqlQuery(gameName);
            String json = HttpUtils.sendSparqlRequest(ENDPOINT, query);
            return parseGameJson(json, gameName);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to query WikiData for game: " + gameName, e);
            return Optional.empty();
        }
    }

    private static String buildSparqlQuery(String gameName) {
        return SPARQL_TEMPLATE.formatted(INSTANCE_OF_VIDEO_GAME, gameName, LANGUAGE, LANGUAGE);
    }

    private static Optional<Game> parseGameJson(String json, String gameName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        JsonNode bindings = root.path("results").path("bindings");

        if (!bindings.isArray() || bindings.isEmpty()) {
            return Optional.empty();
        }

        Game game = new Game(gameName);

        for (JsonNode item : bindings) {
            if (item.has(FIELD_GENRE)) {
                game.addGenre(new Genre(item.get(FIELD_GENRE).get("value").asText()));
            }
            if (item.has(FIELD_DEVELOPER)) {
                game.addDeveloper(new Developer(item.get(FIELD_DEVELOPER).get("value").asText()));
            }
            if (item.has(FIELD_PLATFORM)) {
                game.addPlatform(new Platform(item.get(FIELD_PLATFORM).get("value").asText()));
            }
//            if (item.has(FIELD_RELEASE_DATE)) {
//                String dateString = item.get(FIELD_RELEASE_DATE).get("value").asText();
//                game.setReleaseDate(LocalDate.parse(dateString.substring(0, 10)));
//            }
        }

        return Optional.of(game);
    }
}    
