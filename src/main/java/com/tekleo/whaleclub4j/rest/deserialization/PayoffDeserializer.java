package com.tekleo.whaleclub4j.rest.deserialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.tekleo.whaleclub4j.rest.responses.Payoff;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PayoffDeserializer implements JsonDeserializer<Payoff> {
    @Override
    public Payoff deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Set<Map.Entry<String, JsonElement>> set = jsonElement.getAsJsonObject().entrySet();
        for (Map.Entry<String, JsonElement> entry : set)
            return new Payoff(entry.getKey(), entry.getValue().getAsDouble());
        return null;
    }
}
