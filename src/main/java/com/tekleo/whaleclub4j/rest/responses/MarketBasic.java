package com.tekleo.whaleclub4j.rest.responses;

import com.tekleo.whaleclub4j.rest.Response;
import com.tekleo.whaleclub4j.rest.requests.GetMarkets;

/**
 * Market with only basic information such as display name and category.
 *
 * For {@link GetMarkets} request
 *
 * @author Leo Ertuna
 */
public class MarketBasic implements Response {
    // The market’s conventional name.
    private String display_name;

    // Asset class.
    private String category;



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public String getDisplayName() {
        return display_name;
    }

    public String getCategory() {
        return category;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Others
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "MarketBasic: display_name=" + display_name + ", category=" + category;
    }
    //------------------------------------------------------------------------------------------------------------------
}