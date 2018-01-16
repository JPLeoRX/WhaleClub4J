package com.tekleo.whaleclub4j;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekleo.whaleclub4j.rest.deserialization.*;
import com.tekleo.whaleclub4j.rest.responses.*;

public class Parser {
    public static Gson gson;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Markets.class, new MarketsDeserializer());
        gsonBuilder.registerTypeAdapter(Payoff.class, new PayoffDeserializer());
        gsonBuilder.registerTypeAdapter(Prices.class, new PricesDeserializer());
        gsonBuilder.registerTypeAdapter(Amount.class, new AmountDeserializer());
        gsonBuilder.registerTypeAdapter(Transactions.class, new TransactionsDeserializer());
        gson = gsonBuilder.create();
    }
}