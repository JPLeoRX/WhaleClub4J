package com.tekleo.whaleclub4j.rest.responses;

public class Limits {
    private long BTC;
    private long DASH;
    private long ETH;
    private long LTC;

    @Override
    public String toString() {
        return "BTC=" + BTC + ", DASH=" + DASH + ", ETH=" + ETH + ", LTC=" + LTC;
    }
}