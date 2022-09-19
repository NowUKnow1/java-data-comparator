package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class MapToStringConverter {
    static final String STYLISH = "stylish";
    static final String JSON = "json";
    static final String YML = "yml";
    public static String convert(Map<String, StatusDefiner> map, String format) throws Exception {
        String result;
        switch (format) {
            case STYLISH:
                result = convertToStylish(map);
                break;
            case JSON:
                result = convertToJson(map);
                break;
            case YML:
                result = convertToYml(map);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }
        return result;
    }
    private static String convertToStylish(Map<String, StatusDefiner> map) throws Exception {
        StringBuilder mapAsString = new StringBuilder("{\n");
        for (Map.Entry<String, StatusDefiner> entry : map.entrySet()) {
            DefinedStatus status = entry.getValue().getStatus();
            switch (status) {
                case CHANGED:
                    mapAsString.append(" - ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getFistFileValue()).append("\n");
                    mapAsString.append(" + ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getSecondFileValue()).append("\n");
                    break;
                case UNCHANGED:
                    mapAsString.append("   ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getFistFileValue()).append("\n");
                    break;
                case DELETED:
                    mapAsString.append(" - ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getFistFileValue()).append("\n");
                    break;
                case ADDED:
                    mapAsString.append(" + ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getSecondFileValue()).append("\n");
                    break;
                default:
                    throw new Exception("Wrong status:" + status);
            }
        }

        mapAsString.append("}");
        mapAsString.delete(mapAsString.length() - 1, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
    private static String convertToJson(Map<String, StatusDefiner> map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
    private static String convertToYml(Map<String, StatusDefiner> map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.writeValueAsString(map);
    }
}
