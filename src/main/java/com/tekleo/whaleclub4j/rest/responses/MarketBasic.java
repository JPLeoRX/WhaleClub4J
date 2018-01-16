package com.tekleo.whaleclub4j.rest.responses;

/**
 * Market with only basic information such as display name and category.
 */
public class MarketBasic {
    // The market’s conventional name.
    private String display_name;

    // Asset class.
    private String category;

    @Override
    public String toString() {
        return "MarketBasic: display_name=" + display_name + ", category=" + category;
    }
}
