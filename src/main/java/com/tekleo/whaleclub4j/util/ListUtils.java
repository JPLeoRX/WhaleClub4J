package com.tekleo.whaleclub4j.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static List<String> toList(String ... stringArray) {
        List<String> stringList = new ArrayList<>();
        for (String str : stringArray)
            stringList.add(str);
        return stringList;
    }
}