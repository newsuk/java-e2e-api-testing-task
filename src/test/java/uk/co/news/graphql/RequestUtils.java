package uk.co.news.graphql;


import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class RequestUtils {
    public static String createBody(String query) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(
                Map.of("query", query)
        );
    }
}
