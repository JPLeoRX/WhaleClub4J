package com.tekleo.whaleclub4j.rest.responses;

public class Payoff {
    private double contractDurationsMinutes;

    @Override
    public String toString() {
        return "Payoff: " +
                "5=" + contractDurationsMinutes;
    }
}