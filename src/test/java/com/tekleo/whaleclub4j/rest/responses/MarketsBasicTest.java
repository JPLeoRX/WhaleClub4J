package com.tekleo.whaleclub4j.rest.responses;

import com.tekleo.whaleclub4j.Parser;
import com.tekleo.whaleclub4j.rest.responses.markets.MarketsBasic;
import org.junit.Test;

public class MarketsBasicTest {
    @Test
    public void test() {
        String json = "{\n" +
                "  \"BTC-USD\": {\n" +
                "    \"display_name\": \"BTC/USD\",\n" +
                "    \"category\": \"crypto\"\n" +
                "  },\n" +
                "  \"EUR-USD\": {\n" +
                "    \"display_name\": \"EUR/USD\",\n" +
                "    \"category\": \"forex\"\n" +
                "  },\n" +
                "  \"USD-JPY\": {\n" +
                "    \"display_name\": \"USD/JPY\",\n" +
                "    \"category\": \"forex\"\n" +
                "  },\n" +
                "  \"XAU-USD\": {\n" +
                "    \"display_name\": \"Gold\",\n" +
                "    \"category\": \"commodities\"\n" +
                "  },\n" +
                "  \"AAPL\": {\n" +
                "    \"display_name\": \"Apple\",\n" +
                "    \"category\": \"stocks\"\n" +
                "  }\n" +
                "}";

        MarketsBasic marketsBasic = Parser.gson.fromJson(json, MarketsBasic.class);

        System.out.println(marketsBasic);
    }

}