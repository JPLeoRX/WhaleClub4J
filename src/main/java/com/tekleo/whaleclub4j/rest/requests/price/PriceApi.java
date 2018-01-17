package com.tekleo.whaleclub4j.rest.requests.price;

import com.tekleo.whaleclub4j.rest.responses.Price;
import com.tekleo.whaleclub4j.rest.responses.Prices;

import java.util.List;

public interface PriceApi {
    Prices getPrices(List<String> symbols);

    Price getPrices(String ... symbols);

    Price getPrices();
}