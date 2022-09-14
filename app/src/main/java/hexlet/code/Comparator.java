package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {
    public static Map<String, String> genDiff(Map<String, Object> firstDictionary, Map<String, Object> secondDictionary) {
        Map<String, String> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>();
        keys.addAll(firstDictionary.keySet());
        keys.addAll(secondDictionary.keySet());
        for (String key : keys) {
            if (firstDictionary.containsKey(key) && secondDictionary.containsKey(key)) {
                if (!firstDictionary.get(key).equals(secondDictionary.get(key))) {
                    result.put(key, "changed");
                } else {
                    result.put(key, "unchanged");
                }
            } else if (firstDictionary.containsKey(key)) {
                result.put(key, "deleted");
            } else if (secondDictionary.containsKey(key)) {
                result.put(key, "added");
            }
        }
        return result;
    }
}
