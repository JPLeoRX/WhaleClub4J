package com.tekleo.whaleclub4j.rest.responses;

import com.tekleo.whaleclub4j.Parser;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarketBasicTest {
    @Test
    public void test1() {
        String json = "{\n" +
                "    \"display_name\": \"BTC/USD\",\n" +
                "    \"category\": \"crypto\"\n" +
                "  }";

        MarketBasic marketBasic = Parser.gson.fromJson(json, MarketBasic.class);

        assertEquals("BTC/USD", marketBasic.getDisplayName());
        assertEquals("crypto", marketBasic.getCategory());
    }

    @Test
    public void test2() {
        String json = "{\n" +
                "    \"display_name\": \"EUR/USD\",\n" +
                "    \"category\": \"forex\"\n" +
                "  }";

        MarketBasic marketBasic = Parser.gson.fromJson(json, MarketBasic.class);

        assertEquals("EUR/USD", marketBasic.getDisplayName());
        assertEquals("forex", marketBasic.getCategory());
    }

    @Test
    public void test3() {
        String json = "{\n" +
                "    \"display_name\": \"USD/JPY\",\n" +
                "    \"category\": \"forex\"\n" +
                "  }";

        MarketBasic marketBasic = Parser.gson.fromJson(json, MarketBasic.class);

        assertEquals("USD/JPY", marketBasic.getDisplayName());
        assertEquals("forex", marketBasic.getCategory());
    }

    @Test
    public void test4() {
        String json = "{\n" +
                "    \"display_name\": \"Gold\",\n" +
                "    \"category\": \"commodities\"\n" +
                "  }";

        MarketBasic marketBasic = Parser.gson.fromJson(json, MarketBasic.class);

        assertEquals("Gold", marketBasic.getDisplayName());
        assertEquals("commodities", marketBasic.getCategory());
    }

    @Test
    public void test5() {
        String json = "{\n" +
                "    \"display_name\": \"Apple\",\n" +
                "    \"category\": \"stocks\"\n" +
                "  }";

        MarketBasic marketBasic = Parser.gson.fromJson(json, MarketBasic.class);

        assertEquals("Apple", marketBasic.getDisplayName());
        assertEquals("stocks", marketBasic.getCategory());
    }
}