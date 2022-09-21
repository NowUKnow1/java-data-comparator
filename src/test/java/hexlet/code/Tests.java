package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.assertj.core.api.Assertions.assertThat;

public class Tests {
    private static String firstResult;
    private static String secondResult;
    private static String thirdResult;
    private static String fourthResult;
    private static String fifthResult;
    private static String sixthResult;
    private static String seventhResult;

    @BeforeAll
    public static void beforeAll() throws Exception {
        firstResult = "{\n"
                + " - Chords: [c, d, e]\n"
                + " - Good song?: true\n"
                + " + Good song?: false\n"
                + " - Haters: null\n"
                + " + Haters: 5\n"
                + " - Song: Best kept secret\n"
                + " + Song: Wrecking ball\n"
                + "   Year of song: 2003\n"
                + "}";
        secondResult = "{\n"
                + " - Chords: [c, d, e]\n"
                + " - Good song?: true\n"
                + " - Haters: null\n"
                + " - Song: Best kept secret\n"
                + " - Year of song: 2003\n"
                + "}";
        thirdResult = "{\n"
                + " + Chords: [c, d, e]\n"
                + " + Good song?: true\n"
                + " + Haters: null\n"
                + " + Song: Best kept secret\n"
                + " + Year of song: 2003\n"
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
        String expectation = "Incorrect format";
        try {
            Differ.generate(firstFilePath, secondFilePath, "stylish");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(expectation);
        }
    }
}
