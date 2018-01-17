package com.tekleo.whaleclub4j.rest.deserialization;

import com.google.gson.*;
import com.tekleo.whaleclub4j.rest.responses.markets.MarketBasic;
import com.tekleo.whaleclub4j.rest.responses.markets.MarketsBasic;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Deserializer for {@link MarketsBasic} object
 *
 * @author Leo Ertuna
 */
public class MarketsBasicDeserializer implements JsonDeserializer<MarketsBasic> {
    @Override
    public MarketsBasic deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        // Create new object
        MarketsBasic markets = new MarketsBasic();

        // For each pair
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet())
            // Store it with key and value
            markets.put(entry.getKey(), jsonDeserializationContext.deserialize(entry.getValue(), MarketBasic.class));

        // Return resulting map
        return markets;
    }
}