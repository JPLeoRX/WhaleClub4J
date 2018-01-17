package com.tekleo.whaleclub4j.rest.deserialization;

import com.google.gson.*;
import com.tekleo.whaleclub4j.rest.responses.markets.Markets;
import com.tekleo.whaleclub4j.rest.responses.markets.Market;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Deserializer for {@link Markets} object
 *
 * @author Leo Ertuna
 */
public class MarketsDeserializer implements JsonDeserializer<Markets> {
    @Override
    public Markets deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        // Create new object
        Markets markets = new Markets();

        // For each pair
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet())
            // Store it with key and value
            markets.put(entry.getKey(), jsonDeserializationContext.deserialize(entry.getValue(), Market.class));

        // Return resulting map
        return markets;
    }
}