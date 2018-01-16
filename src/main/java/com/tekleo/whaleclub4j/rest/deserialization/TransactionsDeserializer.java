package com.tekleo.whaleclub4j.rest.deserialization;

import com.google.gson.*;
import com.tekleo.whaleclub4j.rest.responses.Transaction;
import com.tekleo.whaleclub4j.rest.responses.Transactions;

import java.lang.reflect.Type;

public class TransactionsDeserializer implements JsonDeserializer<Transactions>{
    @Override
    public Transactions deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Transactions transactions = new Transactions();

        for (JsonElement element : jsonElement.getAsJsonArray()) {
            transactions.add(jsonDeserializationContext.deserialize(element, Transaction.class));
        }

        return transactions;
    }
}
