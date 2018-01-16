package rest.responses;

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

    @Override
    public String toString() {
        return "limit=" + limit + ", payoff=" + payoff + ", limits={" + limits + "}";
    }
}