package hexlet.code.parser;

import java.util.Map;

public class Parser {
    private static final String JSON = "json";
    private static final String YML = "yml";
    public static Map<String, Object> getData(String filePath, String format) throws Exception {
        Map<String, Object> result;
        switch (format) {
            case JSON:
                return JsonParser.getData(filePath);
            case YML:
                return YmlParser.getData(filePath);
            default:
                throw new Exception("Wrong format" + format);
        }
    }
}
