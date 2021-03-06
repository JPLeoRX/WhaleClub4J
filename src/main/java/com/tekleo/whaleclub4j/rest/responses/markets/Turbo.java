package com.tekleo.whaleclub4j.rest.responses.markets;

/**
 * Information about turbo trading
 */
public class Turbo {
    // Maximum active position size for base currency
    private int limit;

    // Payoff contains the contract duration (in minutes) and the associated payoff.
    private Payoff payoff;

    // Maximum active position size for each base currency
    private Limits limits;

    public int getLimit() {
        return limit;
    }

    public Payoff getPayoff() {
        return payoff;
    }

    public Limits getLimits() {
        return limits;
    }

    @Override
    public String toString() {
        return "limit=" + limit + ", payoff=" + payoff + ", limits={" + limits + "}";
    }
}