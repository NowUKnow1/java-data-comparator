package hexlet.code.Formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.StatusDefiner;

import java.util.Map;

public class Yml {
    public static String convertToYml(Map<String, StatusDefiner> map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.writeValueAsString(map);
    }
}
