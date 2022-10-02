package hexlet.code.formatter;

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
                return StylishConverter.convertToStylish(map);
            case JSON:
                return JsonConverter.convertToJson(map);
            case YML:
                return YmlConverter.convertToYml(map);
            case PLAIN:
                return PlainConverter.convertToPlain(map);
            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }
    }
}
