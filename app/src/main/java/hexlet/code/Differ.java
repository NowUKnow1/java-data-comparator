package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class Differ {
    private static final String JSON = "json";
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String firstFormat = getFormat(filepath1);
        String secondFormat = getFormat(filepath2);

        String firstReadData = read(filepath1, firstFormat);
        String secondReadData = read(filepath2, secondFormat);

        Map<String, Object> dataFromFirstFile = Parser.getMap(firstReadData, firstFormat);
        Map<String, Object> dataFromSecondFile = Parser.getMap(secondReadData, secondFormat);

        LinkedHashMap<String, Object> differenceMap = Comparator.genDiff(dataFromFirstFile, dataFromSecondFile);
    }

    public static String read(String filePath, String format) throws Exception{
        if (!format.equals(JSON)) {
            throw new Exception("Incorrect format");
        }
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }

    public static String getFormat(String filepath) {
        int formatIndex = filepath.lastIndexOf(".");
        if (formatIndex > 0) {
            return filepath.substring(formatIndex + 1);
        }
        return "";
    }
}
