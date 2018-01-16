package com.tekleo.whaleclub4j.rest.responses;

public class Price {
    // The current bid price.
    private double bid;

    // The current ask price.
    private double ask;

    // Can be open, closed, pre (pre-market trading – stocks only), or after (after-market trading – stocks only)
    private String state;

    // When prices for this market were last updated.
    private long last_updated;

    @Override
    public String toString() {
        return "Price: {" +
                "bid=" + bid +
                ", ask=" + ask +
                ", state=" + state +
                ", last_updated=" + last_updated + "}";
    }
}
