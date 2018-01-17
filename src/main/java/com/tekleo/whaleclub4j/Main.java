package com.tekleo.whaleclub4j;

import com.tekleo.whaleclub4j.rest.Endpoints;
import com.tekleo.whaleclub4j.rest.requests.GetMarkets;
import com.tekleo.whaleclub4j.rest.requests.GetTransactions;

public class Main {
    public static void main(String[] args) {
        String jsonStr = new GetMarkets().send();
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