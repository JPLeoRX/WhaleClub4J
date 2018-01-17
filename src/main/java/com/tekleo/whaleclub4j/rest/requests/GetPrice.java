package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.util.ListUtils;

import java.util.List;
import java.util.Map;

/**
 * Returns the current bid and ask prices for one or more markets.
 *
 * GET https://api.whaleclub.co/v1/price/:symbol(s)
 *
 * :symbol(s) is a list of one or more comma-separated market symbols.
 * You can request price for up to 5 markets at once.
 *
 * You can get a list of available symbols using the {@link GetMarkets} endpoint.
 *
 * EX: Request the current price for BTC/USD and EUR/USD
 * https://api.whaleclub.co/v1/price/BTC-USD,EUR-USD
 *
 * @author Leo Ertuna
 */
public class GetPrice implements Request {
    // Required. One or more comma-separated market symbols.
    private List<String> symbols;

    public GetPrice(String ... symbols) {
        this.symbols = ListUtils.toList(symbols);
    }

    @Override
    public Type getType() {
        return Type.GET;
    }

    @Override
    public String getMethod() {
        return "/price";
    }

    @Override
    public List<String> getArguments() {
        return symbols;
    }

    @Override
    public Map<String, String> getParameters() {
        return null;
    }
}