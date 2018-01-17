package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.util.ListUtils;

import java.util.List;
import java.util.Map;

/**
 * Returns market information for one or more markets.
 *
 * GET https://api.whaleclub.co/v1/markets/:symbol(s)
 *
 * :symbol(s) is a list of one or more comma-separated market symbols.
 * You can request market information for up to 5 markets at once.
 *
 * Omit :symbol(s) to get a list of of available markets with basic
 * information such as display name and category.
 *
 * EX: Request market information for Gold and Apple
 * https://api.whaleclub.co/v1/markets/XAU-USD,AAPL
 *
 * EX: Request a list of all available markets
 * https://api.whaleclub.co/v1/markets
 *
 * @author Leo Ertuna
 */
public class GetMarkets implements Request {
    // Optional. One or more comma-separated market symbols.
    private List<String> symbols;

    public GetMarkets(String ... symbols) {
        this.symbols = ListUtils.toList(symbols);
    }

    @Override
    public Type getType() {
        return Type.GET;
    }

    @Override
    public String getMethod() {
        return "/markets";
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