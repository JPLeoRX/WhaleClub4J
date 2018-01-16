package rest.deserialization;

import com.google.gson.*;
import rest.responses.Price;
import rest.responses.Prices;

import java.lang.reflect.Type;
import java.util.Map;

public class PricesDeserializer implements JsonDeserializer<Prices> {
    @Override
    public Prices deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Prices prices = new Prices();

        JsonObject rootObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : rootObject.entrySet())
            prices.add(entry.getKey(), jsonDeserializationContext.deserialize(entry.getValue(), Price.class));

        return prices;
    }
}
