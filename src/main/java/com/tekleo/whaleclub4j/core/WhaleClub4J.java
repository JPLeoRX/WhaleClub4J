package com.tekleo.whaleclub4j.core;

import com.tekleo.whaleclub4j.rest.Endpoints;
import com.tekleo.whaleclub4j.rest.requests.markets.MarketsApi;
import com.tekleo.whaleclub4j.rest.requests.markets.MarketsApiImpl;
import com.tekleo.whaleclub4j.rest.responses.markets.Markets;
import com.tekleo.whaleclub4j.rest.responses.markets.MarketsBasic;

import java.util.List;

public class WhaleClub4J {
    private MarketsApi marketsApi = new MarketsApiImpl();

    public WhaleClub4J(String apiToken) {
        Endpoints.setApiToken(apiToken);
    }

    public Markets getMarkets(List<String> symbols) {
        return marketsApi.getMarkets(symbols);
    }

    public Markets getMarkets(String... symbols) {
        return marketsApi.getMarkets(symbols);
    }

    public MarketsBasic getMarkets() {
        return marketsApi.getMarkets();
    }
}
