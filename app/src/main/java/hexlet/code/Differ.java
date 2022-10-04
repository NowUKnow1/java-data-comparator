package hexlet.code;

import hexlet.code.formatter.Formatter;
import hexlet.code.parser.Parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String firstFormat = getExtension(filepath1);
        String secondFormat = getExtension(filepath2);
        if (!firstFormat.equals(secondFormat)) {
            throw new Exception("File formats are different. Check files format.");
        }

        String firstReadData = read(filepath1);
        String secondReadData = read(filepath2);

        Map<String, Object> dataFromFirstFile = Parser.getData(firstReadData, firstFormat);
        Map<String, Object> dataFromSecondFile = Parser.getData(secondReadData, secondFormat);

        Map<String, ItemData> differenceMap = DiffBuilder.genDiff(dataFromFirstFile, dataFromSecondFile);

        return Formatter.convert(differenceMap, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String read(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        path = path.toAbsolutePath();
        return Files.readString(path);
    }

    public static String getExtension(String filepath) {
        int formatIndex = filepath.lastIndexOf(".");
        return formatIndex > 0 ? filepath.substring(formatIndex + 1) : "";
    }
}
