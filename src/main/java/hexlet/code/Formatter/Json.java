package hexlet.code.Formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.StatusDefiner;

import java.util.Map;

public class Json {
    public static String convertToJson(Map<String, StatusDefiner> map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}
