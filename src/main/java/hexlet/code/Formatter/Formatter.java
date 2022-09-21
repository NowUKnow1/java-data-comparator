package hexlet.code.Formatter;

import hexlet.code.StatusDefiner;

import java.util.Map;

public class Formatter {
    private static final String STYLISH = "stylish";
    private static final String JSON = "json";
    private static final String YML = "yml";
    private static final String PLAIN = "plain";
    public static String convert(Map<String, StatusDefiner> map, String format) throws Exception {
        String result;
        switch (format) {
            case STYLISH:
                result = Stylish.convertToStylish(map);
                break;
            case JSON:
                result = Json.convertToJson(map);
                break;
            case YML:
                result = Yml.convertToYml(map);
                break;
            case PLAIN:
                result = Plain.convertToPlain(map);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }
        return result;
    }
}
