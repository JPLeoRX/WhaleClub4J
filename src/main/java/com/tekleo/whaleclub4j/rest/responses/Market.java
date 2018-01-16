package com.tekleo.whaleclub4j.rest.responses;

import com.tekleo.whaleclub4j.rest.Response;
import com.tekleo.whaleclub4j.rest.requests.GetMarkets;

import java.util.Arrays;

/**
 * Main representation of the market
 *
 * For {@link GetMarkets} request
 *
 * @author Leo Ertuna
 */
public class Market implements Response {
    // The market’s conventional name.
    private String display_name;

    // Leverage levels available.
    private double[] leverages;

    // Maximum active position size for base currency
    private long limit;

    // Market operating hours. Market is closed at all other times.
    private String hours;

    // Daily financing rate. Multiply by 100 to get the amount in percent.
    private double financing_rate;

    // Asset class.
    private String category;

    // Information about turbo trading, if it’s available for this market.
    private Turbo turbo;

    // Maximum active position size for each base currency
    private Limits limits;



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public String getDisplay_name() {
        return display_name;
    }

    public double[] getLeverages() {
        return leverages;
    }

    public long getLimit() {
        return limit;
    }

    public String getHours() {
        return hours;
    }

    public double getFinancing_rate() {
        return financing_rate;
    }

    public String getCategory() {
        return category;
    }

    public Turbo getTurbo() {
        return turbo;
    }

    public Limits getLimits() {
        return limits;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Others
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Market{" +
                "display_name='" + display_name + '\'' +
                ", leverages=" + Arrays.toString(leverages) +
                ", limit=" + limit +
                ", hours='" + hours + '\'' +
                ", financing_rate=" + financing_rate +
                ", category='" + category + '\'' +
                ", turbo=" + turbo +
                ", limits=" + limits +
                '}';
    }
    //------------------------------------------------------------------------------------------------------------------
}