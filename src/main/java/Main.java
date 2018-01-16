import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rest.Endpoints;
import rest.deserialization.MarketsDeserializer;
import rest.deserialization.PricesDeserializer;
import rest.requests.GetBalance;
import rest.requests.GetPrice;
import rest.responses.Markets;
import rest.responses.Price;
import rest.responses.Prices;

public class Main {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Markets.class, new MarketsDeserializer());
        gsonBuilder.registerTypeAdapter(Prices.class, new PricesDeserializer());
        Gson gson = gsonBuilder.create();

        Client client = new Client(new GetBalance().getUrl(), Endpoints.API_TOKEN);



        String jsonStr = client.send();
        System.out.println(jsonStr);

//        Markets markets = gson.fromJson(jsonStr, Markets.class);
//        System.out.println(markets);

//        Prices prices = gson.fromJson(jsonStr, Prices.class);
//        System.out.println(prices);
    }
}