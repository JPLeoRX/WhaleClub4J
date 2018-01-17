package com.tekleo.whaleclub4j.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static Map<String, String> toMap(String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
