package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private static final String JSON = "json";
    private static final String YML = "yml";
    public static Map<String, Object> getMap(String filePath, String format) throws Exception {
        Map<String, Object> result = new HashMap<>();
        switch (format) {
            case JSON:
                result = getMapFromJson(filePath);
                break;
            case YML:
                result = getMapFromYml(filePath);
                break;
            default:
                throw new Exception("Wrong format" + format);
        }
        return result;
    }
    public static Map<String, Object> getMapFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = mapper.readValue(filePath, new TypeReference<Map<String, Object>>() { });
        return result;
    }
    public static Map<String, Object> getMapFromYml(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> result = mapper.readValue(filePath, new TypeReference<Map<String, Object>>() { });
        return result;
    }
}
