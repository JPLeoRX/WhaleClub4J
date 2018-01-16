package com.tekleo.whaleclub4j.rest.responses;

public class Limits {
    private long BTC;
    private long DASH;
    private long ETH;
    private long LTC;

    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public long getBTC() {
        return BTC;
    }

    public long getDASH() {
        return DASH;
    }

    public long getETH() {
        return ETH;
    }

    public long getLTC() {
        return LTC;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "BTC=" + BTC + ", DASH=" + DASH + ", ETH=" + ETH + ", LTC=" + LTC;
    }
}