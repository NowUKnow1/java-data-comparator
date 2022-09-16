package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> getMap(String filePath, String format) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = mapper.readValue(filePath, new TypeReference<Map<String, Object>>(){});
        return result;
    }
}
