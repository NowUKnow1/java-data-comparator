package hexlet.gradle.project;

import hexlet.gradle.project.Formatter.Formatter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Differ {
    private static final String JSON = "json";
    private static final String YML = "yml";
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String firstFormat = getExtension(filepath1);
        String secondFormat = getExtension(filepath2);
        if (!firstFormat.equals(secondFormat)) {
            throw new Exception("File formats are different. Check files format.");
        }

        String firstReadData = read(filepath1, firstFormat);
        String secondReadData = read(filepath2, secondFormat);

        Map<String, Object> dataFromFirstFile = ParserFormatDefiner.getMap(firstReadData, firstFormat);
        Map<String, Object> dataFromSecondFile = ParserFormatDefiner.getMap(secondReadData, secondFormat);

        Map<String, ItemData> differenceMap = DiffBuilder.genDiff(dataFromFirstFile, dataFromSecondFile);

        return Formatter.convert(differenceMap, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        String firstFormat = getExtension(filepath1);
        String secondFormat = getExtension(filepath2);
        if (!firstFormat.equals(secondFormat)) {
            throw new Exception("File formats are different. Check files format.");
        }

        String firstData = read(filepath1, firstFormat);
        String secondData = read(filepath2, secondFormat);

        Map<String, Object> dataFromFirstFile = ParserFormatDefiner.getMap(firstData, firstFormat);
        Map<String, Object> dataFromSecondFile = ParserFormatDefiner.getMap(secondData, secondFormat);

        Map<String, ItemData> differenceMap = DiffBuilder.genDiff(dataFromFirstFile, dataFromSecondFile);

        return Formatter.convert(differenceMap, "stylish");
    }

    public static String read(String filePath, String format) throws Exception {
        List<String> formatList = new ArrayList<>();
        formatList.add(JSON);
        formatList.add(YML);
        if (!formatList.contains(format)) {
            throw new Exception("Incorrect format");
        }
        Path path = Paths.get(filePath);
        if (!path.isAbsolute()) {
            path.toAbsolutePath();
            return Files.readString(path);
        }
        return Files.readString(path);
    }

    public static String getExtension(String filepath) {
        int formatIndex = filepath.lastIndexOf(".");
        return formatIndex > 0 ? filepath.substring(formatIndex + 1) : "";
    }
}
