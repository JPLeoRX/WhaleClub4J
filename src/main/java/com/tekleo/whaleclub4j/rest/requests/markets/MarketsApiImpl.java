package com.tekleo.whaleclub4j.rest.requests.markets;

import com.tekleo.whaleclub4j.core.Parser;
import com.tekleo.whaleclub4j.rest.responses.markets.Markets;
import com.tekleo.whaleclub4j.rest.responses.markets.MarketsBasic;

import java.util.List;

public class MarketsApiImpl implements MarketsApi {
    @Override
    public Markets getMarkets(List<String> symbols) {
        GetMarkets getMarkets = new GetMarkets(symbols);
        return Parser.fromJson(getMarkets.send(), Markets.class);
    }

    @Override
    public Markets getMarkets(String... symbols) {
        GetMarkets getMarkets = new GetMarkets(symbols);
        return Parser.fromJson(getMarkets.send(), Markets.class);
    }

    @Override
    public MarketsBasic getMarkets() {
        GetMarkets getMarkets = new GetMarkets();
        return Parser.fromJson(getMarkets.send(), MarketsBasic.class);
    }
}
