package com.tekleo.whaleclub4j.core;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.tekleo.whaleclub4j.rest.deserialization.*;
import com.tekleo.whaleclub4j.rest.responses.*;
import com.tekleo.whaleclub4j.rest.responses.markets.Markets;
import com.tekleo.whaleclub4j.rest.responses.markets.MarketsBasic;
import com.tekleo.whaleclub4j.rest.responses.markets.Payoff;

import java.io.Reader;
import java.lang.reflect.Type;

public class Parser {
    public static Gson gson;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Markets.class, new MarketsDeserializer());
        gsonBuilder.registerTypeAdapter(MarketsBasic.class, new MarketsBasicDeserializer());
        gsonBuilder.registerTypeAdapter(Payoff.class, new PayoffDeserializer());
        gsonBuilder.registerTypeAdapter(Prices.class, new PricesDeserializer());
        gsonBuilder.registerTypeAdapter(Amount.class, new AmountDeserializer());
        gsonBuilder.registerTypeAdapter(Transactions.class, new TransactionsDeserializer());
        gson = gsonBuilder.create();
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        return gson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return gson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return gson.fromJson(reader, typeOfT);
    }

    public static <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(JsonElement json, Type typeOfT) throws JsonSyntaxException {
        return gson.fromJson(json, typeOfT);
    }
}