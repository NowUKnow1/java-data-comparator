package hexlet.code.Formatter;

import hexlet.code.ItemData;

import java.util.Map;

public class Formatter {
    private static final String STYLISH = "stylish";
    private static final String JSON = "json";
    private static final String YML = "yml";
    private static final String PLAIN = "plain";
    public static String convert(Map<String, ItemData> map, String format) throws Exception {
        String result = STYLISH;
        switch (format) {
            case STYLISH:
                result = StylishConverter.convertToStylish(map);
                break;
            case JSON:
                result = JsonConverter.convertToJson(map);
                break;
            case YML:
                result = YmlConverter.convertToYml(map);
                break;
            case PLAIN:
                result = PlainConverter.convertToPlain(map);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }
        return result;
    }
}
