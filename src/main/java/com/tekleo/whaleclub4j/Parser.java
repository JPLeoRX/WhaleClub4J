package com.tekleo.whaleclub4j;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekleo.whaleclub4j.rest.deserialization.AmountDeserializer;
import com.tekleo.whaleclub4j.rest.deserialization.MarketsDeserializer;
import com.tekleo.whaleclub4j.rest.deserialization.PricesDeserializer;
import com.tekleo.whaleclub4j.rest.deserialization.TransactionsDeserializer;
import com.tekleo.whaleclub4j.rest.responses.Amount;
import com.tekleo.whaleclub4j.rest.responses.Markets;
import com.tekleo.whaleclub4j.rest.responses.Prices;
import com.tekleo.whaleclub4j.rest.responses.Transactions;

public class Parser {
    public static Gson gson;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Markets.class, new MarketsDeserializer());
        gsonBuilder.registerTypeAdapter(Prices.class, new PricesDeserializer());
        gsonBuilder.registerTypeAdapter(Amount.class, new AmountDeserializer());
        gsonBuilder.registerTypeAdapter(Transactions.class, new TransactionsDeserializer());
        gson = gsonBuilder.create();
    }
}