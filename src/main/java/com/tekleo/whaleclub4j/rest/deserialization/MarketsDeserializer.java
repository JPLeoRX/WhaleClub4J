package com.tekleo.whaleclub4j.rest.deserialization;

import com.google.gson.*;
import com.tekleo.whaleclub4j.rest.responses.Markets;
import com.tekleo.whaleclub4j.rest.responses.Market;

import java.lang.reflect.Type;
import java.util.Map;

public class MarketsDeserializer implements JsonDeserializer<Markets> {
    @Override
    public Markets deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Markets markets = new Markets();

        JsonObject rootObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : rootObject.entrySet())
            markets.add(entry.getKey(), jsonDeserializationContext.deserialize(entry.getValue(), Market.class));

        return markets;
    }
}
