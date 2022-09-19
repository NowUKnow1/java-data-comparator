package hexlet.code;

// import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    private static final String JSON = "json";
    private static final String YML = "yml";
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String firstFormat = getFormat(filepath1);
        String secondFormat = getFormat(filepath2);

        String firstReadData = read(filepath1, firstFormat);
        String secondReadData = read(filepath2, secondFormat);

        Map<String, Object> dataFromFirstFile = Parser.getMap(firstReadData, firstFormat);
        Map<String, Object> dataFromSecondFile = Parser.getMap(secondReadData, secondFormat);

        Map<String, StatusDefiner> differenceMap = Comparator.genDiff(dataFromFirstFile, dataFromSecondFile);

        //ObjectMapper mapper = new ObjectMapper();
        return MapToStringConverter.convert(differenceMap, format);
    }

    public static String read(String filePath, String format) throws Exception {
        if (!format.equals(JSON) && !format.equals(YML)) {
            throw new Exception("Incorrect format");
        }
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }

    public static String getFormat(String filepath) {
        int formatIndex = filepath.lastIndexOf(".");
        return formatIndex > 0 ? filepath.substring(formatIndex + 1) : "";
    }
}
