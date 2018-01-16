import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rest.Endpoints;
import rest.deserialization.AmountDeserializer;
import rest.deserialization.MarketsDeserializer;
import rest.deserialization.PricesDeserializer;
import rest.deserialization.TransactionsDeserializer;
import rest.requests.GetBalance;
import rest.requests.GetPrice;
import rest.requests.GetTransactions;
import rest.responses.*;

public class Main {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Markets.class, new MarketsDeserializer());
        gsonBuilder.registerTypeAdapter(Prices.class, new PricesDeserializer());
        gsonBuilder.registerTypeAdapter(Amount.class, new AmountDeserializer());
        gsonBuilder.registerTypeAdapter(Transactions.class, new TransactionsDeserializer());
        Gson gson = gsonBuilder.create();

        Client client = new Client(new GetTransactions().getUrl(), Endpoints.API_TOKEN);



        String jsonStr = client.send();
        System.out.println(jsonStr);

//        Markets markets = gson.fromJson(jsonStr, Markets.class);
//        System.out.println(markets);
//
//        Prices prices = gson.fromJson(jsonStr, Prices.class);
//        System.out.println(prices);
//
//        Balance balance = gson.fromJson(jsonStr, Balance.class);
//        System.out.println(balance);
//
//        Transactions transactions = gson.fromJson(jsonStr, Transactions.class);
//        System.out.println(transactions);
    }
}