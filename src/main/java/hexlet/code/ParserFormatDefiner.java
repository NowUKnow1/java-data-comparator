package hexlet.code;

import java.util.Map;

public class ParserFormatDefiner {
    private static final String JSON = "json";
    private static final String YML = "yml";
    public static Map<String, Object> getMap(String filePath, String format) throws Exception {
        Map<String, Object> result;
        switch (format) {
            case JSON:
                result = JsonParser.getData(filePath);
                break;
            case YML:
                result = YmlParser.getData(filePath);
                break;
            default:
                throw new Exception("Wrong format" + format);
        }
        return result;
    }


}
