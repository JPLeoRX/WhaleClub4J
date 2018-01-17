package com.tekleo.whaleclub4j.rest.requests.markets;

import com.tekleo.whaleclub4j.rest.responses.markets.Markets;
import com.tekleo.whaleclub4j.rest.responses.markets.MarketsBasic;

import java.util.List;

public interface MarketsApi {
    // Returns market information for one or more markets.
    Markets getMarkets(List<String> symbols);

    // Returns market information for one or more markets.
    Markets getMarkets(String ... symbols);

    // Get a list of of available markets with basic information such as display name and category.
    MarketsBasic getMarkets();
}
