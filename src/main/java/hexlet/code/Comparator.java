package hexlet.code;

import java.util.*;

public class Comparator {
    public static Map<String, StatusDefiner> genDiff(Map<String, Object> firstMap,
                                                     Map<String, Object> secondMap) {

        Map<String, StatusDefiner> diffs = new TreeMap<>();

        Set<String> firstKeys = firstMap.keySet();
        Set<String> secondKeys = secondMap.keySet();
        TreeSet<String> unionKeys = new TreeSet<>(firstKeys);
        unionKeys.addAll(secondKeys);

        for (String key : unionKeys) {
            boolean isFirstMapHasKey = firstMap.containsKey(key);
            boolean isSecondMapHasKey = secondMap.containsKey(key);
            if (isFirstMapHasKey && isSecondMapHasKey
                    && String.valueOf(firstMap.get(key)).equals(String.valueOf(secondMap.get(key)))) {
                diffs.put(key, new StatusDefiner(firstMap.get(key), secondMap.get(key), "unchanged"));
            } else if (isFirstMapHasKey && isSecondMapHasKey
                    && !String.valueOf(firstMap.get(key)).equals(String.valueOf(secondMap.get(key)))) {
                diffs.put(key, new StatusDefiner(firstMap.get(key), secondMap.get(key), "changed"));
            } else if (isFirstMapHasKey && !isSecondMapHasKey) {
                diffs.put(key, new StatusDefiner(firstMap.get(key), secondMap.get(key), "deleted"));
            } else {
                diffs.put(key, new StatusDefiner(firstMap.get(key), secondMap.get(key), "added"));
            }
        }

        return diffs;
    }
}
