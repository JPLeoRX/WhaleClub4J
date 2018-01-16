package com.tekleo.whaleclub4j.rest.responses;

import com.tekleo.whaleclub4j.rest.requests.GetMarkets;

import java.util.HashMap;

/**
 * Markets represented as HashMap
 *
 * For {@link GetMarkets} request
 *
 * @author Leo Ertuna
 */
public class Markets extends HashMap<String, Market> {
    public void add(String name, Market market) {
        this.put(name, market);
    }

    public Market put(String name, Market market) {
        return super.put(name, market);
    }
}