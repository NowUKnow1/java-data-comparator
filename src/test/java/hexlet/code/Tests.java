package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.assertj.core.api.Assertions.assertThat;

public class Tests {
    
    private static String firstResult;
    private static String secondResult;
    private static String thirdResult;
    
    @BeforeAll
    public static void beforeAll() throws Exception {
        firstResult = "{\n" +
                " - Chords: [c, d, e]\n" +
                " - Good song?: true\n" +
                " + Good song?: false\n" +
                " - Haters: null\n" +
                " + Haters: 5\n" +
                " - Song: Best kept secret\n" +
                " + Song: Wrecking ball\n" +
                "   Year of song: 2003\n" +
                "}";
        secondResult = "{\n" +
                " - Chords: [c, d, e]\n" +
                " - Good song?: true\n" +
                " - Haters: null\n" +
                " - Song: Best kept secret\n" +
                " - Year of song: 2003\n" +
                "}";
        thirdResult = "{\n" +
                " + Chords: [c, d, e]\n" +
                " + Good song?: true\n" +
                " + Haters: null\n" +
                " + Song: Best kept secret\n" +
                " + Year of song: 2003\n" +
                "}";
    }

    @Test
    public void testDiffer() throws Exception {
        String firstFilePath = "./src/test/resources/file1.json";
        String secondFilePath = "./src/test/resources/file2.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "json")).isEqualTo(firstResult);
    }

    @Test
    public void testDifferSecondNullFile() throws Exception {
        String firstFilePath = "./src/test/resources/file1.json";
        String secondFilePath = "./src/test/resources/file3.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "json")).isEqualTo(secondResult);
    }

    @Test
    public void testDifferFirstNullFile() throws Exception {
        String firstFilePath = "./src/test/resources/file3.json";
        String secondFilePath = "./src/test/resources/file1.json";
        assertThat(Differ.generate(firstFilePath, secondFilePath, "json")).isEqualTo(thirdResult);
    }
}
