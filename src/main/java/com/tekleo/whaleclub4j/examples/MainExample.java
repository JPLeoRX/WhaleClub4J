package com.tekleo.whaleclub4j.examples;

import com.tekleo.whaleclub4j.core.WhaleClub4J;
import com.tekleo.whaleclub4j.rest.responses.markets.Markets;
import com.tekleo.whaleclub4j.rest.responses.markets.MarketsBasic;

public class MainExample {
    public static void main(String[] args) {
//        String jsonStr = new GetMarkets().send();
//        System.out.println(jsonStr);
//
//        String url = new NewPosition("long", "AAPL", 10, 20000000).getUrl();
//        System.out.println(url);
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

        WhaleClub4J whaleClub4J = new WhaleClub4J("dc296379-92cf-44d2-827a-66a600a2411a");

        MarketsBasic allMarketsPreview = whaleClub4J.getMarkets();
        Markets myMarkets = whaleClub4J.getMarkets("BTC-USD", "AAPL");

        System.out.println(allMarketsPreview);
        System.out.println(myMarkets);
    }
}