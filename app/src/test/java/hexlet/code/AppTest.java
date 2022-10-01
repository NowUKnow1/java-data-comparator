package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AppTest {
    private static String firstResult;
    private static String secondResult;
    private static String thirdResult;
    private static String fourthResult;
    private static String fifthResult;
    private static String sixthResult;
    private static String seventhResult;
    private static String resultStylish;
    private static String resultPlain;

    @BeforeAll
    public static void beforeAll() throws Exception {
        firstResult = "{\n"
                + "  - Chords: [c, d, e]\n"
                + "  - Good song?: true\n"
                + "  + Good song?: false\n"
                + "  - Haters: null\n"
                + "  + Haters: 5\n"
                + "  - Song: Best kept secret\n"
                + "  + Song: Wrecking ball\n"
                + "    Year of song: 2003\n"
                + "}";
        secondResult = "{\n"
                + "  - Chords: [c, d, e]\n"
                + "  - Good song?: true\n"
                + "  - Haters: null\n"
                + "  - Song: Best kept secret\n"
                + "  - Year of song: 2003\n"
                + "}";
        thirdResult = "{\n"
                + "  + Chords: [c, d, e]\n"
                + "  + Good song?: true\n"
                + "  + Haters: null\n"
                + "  + Song: Best kept secret\n"
                + "  + Year of song: 2003\n"
                + "}";
        fourthResult = "{\n"
                + "}";
        fifthResult = "{\"Chords\":{\"fistFileValue\":[\"c\",\"d\",\"e\"],\"secondFileValue\""
                + ":null,\"status\":\"DELETED\"},\"Good song?\""
                + ":{\"fistFileValue\":true,\"secondFileValue\":false,\"status\":\"CHANGED\"},"
                + "\"Haters\":{\"fistFileValue\":null,\"secondFileValue\""
                + ":5,\"status\":\"CHANGED\"},\"Song\":{\"fistFileValue\":\"Best kept secret\","
                + "\"secondFileValue\":\"Wrecking ball\",\"status\":\"CHANGED\"},"
                + "\"Year of song\":{\"fistFileValue\":2003,\"secondFileValue\":2003,\"status\":\"UNCHANGED\"}}";
        sixthResult = "---\n"
                + "Chords:\n"
                + "  fistFileValue:\n"
                + "  - \"c\"\n"
                + "  - \"d\"\n"
                + "  - \"e\"\n"
                + "  secondFileValue: null\n"
                + "  status: \"DELETED\"\n"
                + "Good song?:\n"
                + "  fistFileValue: true\n"
                + "  secondFileValue: false\n"
                + "  status: \"CHANGED\"\n"
                + "Haters:\n"
                + "  fistFileValue: null\n"
                + "  secondFileValue: 5\n"
                + "  status: \"CHANGED\"\n"
                + "Song:\n"
                + "  fistFileValue: \"Best kept secret\"\n"
                + "  secondFileValue: \"Wrecking ball\"\n"
                + "  status: \"CHANGED\"\n"
                + "Year of song:\n"
                + "  fistFileValue: 2003\n"
                + "  secondFileValue: 2003\n"
                + "  status: \"UNCHANGED\"\n";
        seventhResult = "Property 'Chords' was removed\n"
                + "Property 'Counters' was updated. From [complex value] to [complex value]\n"
                + "Property 'CountersTwo' was removed\n"
                + "Property 'Good song?' was updated. From true to false\n"
                + "Property 'Haters' was updated. From null to 5\n"
                + "Property 'Hello Counters' was added with value: [complex value]\n"
                + "Property 'Song' was updated. From 'Best kept secret' to 'Wrecking ball'";
        resultPlain = getResultFromFile("src/test/resources/result_plain.txt");
        resultStylish = getResultFromFile("src/test/resources/result_stylish.txt");
    }

    private static String getResultFromFile(String path) throws IOException {
        Path gotPath = Path.of(path);
        return Files.readString(gotPath);
    }

    @Test
    public void hexletJavaTests() throws Exception {
        String firstJavaFilePath = "./src/test/resources/file11.json";
        String secondJavaFilePath = "./src/test/resources/file12.json";
        assertThat(Differ.generate(firstJavaFilePath, secondJavaFilePath)).isEqualTo(resultStylish);
        assertThat(Differ.generate(firstJavaFilePath, secondJavaFilePath, "stylish")).isEqualTo(resultStylish);
        assertThat(Differ.generate(firstJavaFilePath, secondJavaFilePath, "plain")).isEqualTo(resultPlain);
    }

    @Test
    public void hexletYmlTests() throws Exception {
        String firstJavaFilePath = "./src/test/resources/file11.yml";
        String secondJavaFilePath = "./src/test/resources/file12.yml";
        assertThat(Differ.generate(firstJavaFilePath, secondJavaFilePath)).isEqualTo(resultStylish);
        assertThat(Differ.generate(firstJavaFilePath, secondJavaFilePath, "stylish")).isEqualTo(resultStylish);
        assertThat(Differ.generate(firstJavaFilePath, secondJavaFilePath, "plain")).isEqualTo(resultPlain);
    }

    @Test
    public void testDiffer() throws Exception {
        String firstFilePath = "./src/test/resources/file1.json";
        String secondFilePath = "./src/test/resources/file2.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "stylish")).isEqualTo(firstResult);
    }

    @Test
    public void testDifferSecondNullFile() throws Exception {
        String firstFilePath = "./src/test/resources/file1.json";
        String secondFilePath = "./src/test/resources/file3.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "stylish")).isEqualTo(secondResult);
    }

    @Test
    public void testDifferFirstNullFile() throws Exception {
        String firstFilePath = "./src/test/resources/file3.json";
        String secondFilePath = "./src/test/resources/file1.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "stylish")).isEqualTo(thirdResult);
    }

    @Test
    public final void testNullFiles() throws Exception {
        String firstFilePath = "./src/test/resources/file3.json";
        String secondFilePath = "./src/test/resources/file3.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "stylish")).isEqualTo(fourthResult);
    }

    @Test
    public void testDifferYml() throws Exception {
        String firstFilePath = "./src/test/resources/file1.yml";
        String secondFilePath = "./src/test/resources/file2.yml";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "stylish")).isEqualTo(firstResult);
    }

    @Test
    public void testDifferJsonFormat() throws Exception {
        String firstFilePath = "./src/test/resources/file1.json";
        String secondFilePath = "./src/test/resources/file2.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "json")).isEqualTo(fifthResult);
    }

    @Test
    public void testDifferYmlFormat() throws Exception {
        String firstFilePath = "./src/test/resources/file1.yml";
        String secondFilePath = "./src/test/resources/file2.yml";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "yml")).isEqualTo(sixthResult);
    }

    @Test
    public void testDifferPlainFormat() throws Exception {
        String firstFilePath = "./src/test/resources/file4.json";
        String secondFilePath = "./src/test/resources/file5.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "plain")).isEqualTo(seventhResult);
    }

    @Test
    public void testDifferWrongFormat() throws Exception {
        String firstFilePath = "./src/test/resources/file1.json";
        String secondFilePath = "./src/test/resources/file2.json";
        String expectation = "Unexpected value: txt";
        try {
            Differ.generate(firstFilePath, secondFilePath, "txt");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(expectation);
        }
    }

    @Test
    public void testDifferWrongFileFormat() throws Exception {
        String firstFilePath = "./src/test/resources/file1.json";
        String secondFilePath = "./src/test/resources/file2.txt";
        String expectation = "File formats are different. Check files format.";
        try {
            Differ.generate(firstFilePath, secondFilePath, "stylish");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(expectation);
        }
    }
}
