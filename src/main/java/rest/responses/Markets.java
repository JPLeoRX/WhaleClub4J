package rest.responses;

import java.util.HashMap;

public class Markets {
    private HashMap<String, Market> map = new HashMap<>();

    public void add(String name, Market market) {
        map.put(name, market);
    }

    @Override
    public String toString() {
        return "Markets: " + map;
    }
}
