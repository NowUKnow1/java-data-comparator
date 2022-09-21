package hexlet.code.Formatter;

import hexlet.code.DefinedStatus;
import hexlet.code.StatusDefiner;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String convertToPlain(Map<String, StatusDefiner> map) throws Exception {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, StatusDefiner> entry : map.entrySet()) {
            DefinedStatus status = entry.getValue().getStatus();
            switch (status) {
                case CHANGED:
                    result.append("Property '")
                            .append(entry.getKey())
                            .append("' was updated. From ")
                            .append(complexValueCheck(entry.getValue().getFistFileValue()))
                            .append(" to ")
                            .append(complexValueCheck(entry.getValue().getSecondFileValue()))
                            .append("\n");
                    break;
                case DELETED:
                    result.append("Property '")
                            .append(entry.getKey())
                            .append("' was removed")
                            .append("\n");
                    break;
                case ADDED:
                    result.append("Property '")
                            .append(entry.getKey())
                            .append("' was added with value: ")
                            .append(complexValueCheck(entry.getValue().getSecondFileValue()))
                            .append("\n");
                    break;
                case UNCHANGED:
                    break;
                default:
                    throw new Exception("Unexpected status:" + status);
            }
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        return result.toString();
    }


    private static String complexValueCheck(Object value) {
        String result;
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else {
            if (value instanceof String) {
                result = "'" + value + "'";
            } else {
                result = String.valueOf(value);
            }
        }
        return result;
    }
}
