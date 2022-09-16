package hexlet.code;

import java.util.Map;

public class MapToStringConverter {
    public static String convert(Map<String, StatusDefiner> map) throws Exception {
        StringBuilder mapAsString = new StringBuilder("{\n");
        for (Map.Entry<String, StatusDefiner> entry : map.entrySet()) {
            String status = entry.getValue().getStatus();
            switch (status) {
                case "changed":
                    mapAsString.append(" - ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getFistFileValue()).append("\n");
                    mapAsString.append(" + ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getSecondFileValue()).append("\n");
                    break;
                case "unchanged":
                    mapAsString.append("   ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getFistFileValue()).append("\n");
                    break;
                case "deleted":
                    mapAsString.append(" - ").append(entry.getKey()).append(": ")
                            .append(entry.getValue().getFistFileValue()).append("\n");
                    break;
                case "added":
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
}
