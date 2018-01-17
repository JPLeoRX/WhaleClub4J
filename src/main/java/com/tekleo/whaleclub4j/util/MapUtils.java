package com.tekleo.whaleclub4j.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {
    public static Map<String, String> toMap(String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    public static List<NameValuePair> toParams(Map<String, String> map) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet())
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        return params;
    }

    public static UrlEncodedFormEntity toEntity(Map<String, String> map) {
        try {
            return new UrlEncodedFormEntity(toParams(map));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}