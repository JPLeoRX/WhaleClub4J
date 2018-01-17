package com.tekleo.whaleclub4j.rest.responses;

import com.tekleo.whaleclub4j.Parser;
import com.tekleo.whaleclub4j.rest.responses.markets.Market;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarketTest {
    @Test
    public void test1() {
        String json = "{\n" +
                "    \"display_name\": \"Gold\",\n" +
                "    \"leverages\": [2, 3.3, 5, 10],\n" +
                "    \"limits\": {\n" +
                "      \"BTC\": 5000000000\n" +
                "    },\n" +
                "    \"hours\": \"Sun 5PM - Fri 5PM\",\n" +
                "    \"financing_rate\": 0.0005,\n" +
                "    \"category\": \"commodities\",\n" +
                "    \"turbo\": {\n" +
                "      \"payoff\": {\n" +
                "        \"5\": 0.5\n" +
                "      },\n" +
                "      \"limits\": {\n" +
                "        \"BTC\": 10000000\n" +
                "      }\n" +
                "    }\n" +
                "  }";

        Market market = Parser.gson.fromJson(json, Market.class);

        assertEquals(true,market != null);
        assertEquals("Gold", market.getDisplay_name());
        assertArrayEquals(new double[]{2, 3.3, 5, 10}, market.getLeverages(), Double.MIN_VALUE);
        assertEquals(5000000000L, market.getLimits().getBTC());
        assertEquals("Sun 5PM - Fri 5PM", market.getHours());
        assertEquals(0.0005, market.getFinancing_rate(), Double.MIN_VALUE);
        assertEquals("commodities", market.getCategory());
        assertEquals("5", market.getTurbo().getPayoff().getDuration());
        assertEquals(0.5, market.getTurbo().getPayoff().getPayoff(), Double.MIN_VALUE);
        assertEquals(10000000L, market.getTurbo().getLimits().getBTC());
    }

    @Test
    public void test2() {
        String json = "{\n" +
                "    \"display_name\": \"Apple\",\n" +
                "    \"leverages\": [3.3, 5, 10, 15],\n" +
                "    \"limits\": {\n" +
                "      \"BTC\": 3000000000\n" +
                "    },\n" +
                "    \"hours\": \"Mon-Fri 8AM-5PM\",\n" +
                "    \"financing_rate\": 0.001,\n" +
                "    \"category\": \"stocks\",\n" +
                "    \"turbo\": {\n" +
                "      \"payoff\": {\n" +
                "        \"5\": 0.5\n" +
                "      },\n" +
                "      \"limits\": {\n" +
                "        \"BTC\": 10000000\n" +
                "      }\n" +
                "    }\n" +
                "  }";

        Market market = Parser.gson.fromJson(json, Market.class);

        assertEquals(true,market != null);
        assertEquals("Apple", market.getDisplay_name());
        assertArrayEquals(new double[]{3.3, 5, 10, 15}, market.getLeverages(), Double.MIN_VALUE);
        assertEquals(3000000000L, market.getLimits().getBTC());
        assertEquals("Mon-Fri 8AM-5PM", market.getHours());
        assertEquals(0.001, market.getFinancing_rate(), Double.MIN_VALUE);
        assertEquals("stocks", market.getCategory());
        assertEquals("5", market.getTurbo().getPayoff().getDuration());
        assertEquals(0.5, market.getTurbo().getPayoff().getPayoff(), Double.MIN_VALUE);
        assertEquals(10000000L, market.getTurbo().getLimits().getBTC());
    }
}