package rest.deserialization;

import com.google.gson.*;
import rest.responses.Amount;

import java.lang.reflect.Type;
import java.util.Map;

public class AmountDeserializer implements JsonDeserializer<Amount> {
    @Override
    public Amount deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Amount amount = new Amount();

        JsonObject rootObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : rootObject.entrySet())
            amount.add(entry.getKey(), entry.getValue().getAsLong());

        return amount;
    }
}
