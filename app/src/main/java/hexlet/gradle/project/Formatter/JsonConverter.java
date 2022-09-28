package hexlet.gradle.project.Formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.gradle.project.ItemData;

import java.util.Map;

public class JsonConverter {
    public static String convertToJson(Map<String, ItemData> map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}
