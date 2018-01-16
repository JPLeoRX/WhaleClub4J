package rest.responses;

import java.util.HashMap;

public class Prices {
    private HashMap<String, Price> map = new HashMap<>();

    public void add(String name, Price price) {
        map.put(name, price);
    }

    @Override
    public String toString() {
        return "Prices: " + map;
    }
}
