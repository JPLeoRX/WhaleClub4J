package com.tekleo.whaleclub4j.rest.responses;

import java.util.HashMap;

public class Amount {
    private HashMap<String, Long> map = new HashMap<>();

    public void add(String name, Long price) {
        map.put(name, price);
    }

    @Override
    public String toString() {
        return "Amount: " + map;
    }
}