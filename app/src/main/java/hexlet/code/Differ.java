package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    private static final String JSON = "json";
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String firstFormat;
        String secondFormat;
        if (format.isEmpty()) {
            firstFormat = getFormat(filepath1);
            secondFormat = getFormat(filepath2);
        } else {
            firstFormat = format;
            secondFormat = format;
        }

        String firstReadData = read(filepath1, firstFormat);
        String secondReadData = read(filepath2, secondFormat);

        Map<String, Object> dataFromFirstFile = Parser.getMap(firstReadData, firstFormat);
        Map<String, Object> dataFromSecondFile = Parser.getMap(secondReadData, secondFormat);

        Map<String, StatusDefiner> differenceMap = Comparator.genDiff(dataFromFirstFile, dataFromSecondFile);

        ObjectMapper mapper = new ObjectMapper();
        return MapToStringConverter.convert(differenceMap);
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
