package com.tekleo.whaleclub4j.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static String[] toArray(List<String> stringList) {
        String[] stringArray = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++)
            stringArray[i] = stringList.get(i);
        return stringArray;
    }
    public static List<String> toList(String ... stringArray) {
        List<String> stringList = new ArrayList<>();
        for (String str : stringArray)
            stringList.add(str);
        return stringList;
    }
}