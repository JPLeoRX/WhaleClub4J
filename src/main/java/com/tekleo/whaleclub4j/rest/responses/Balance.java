package com.tekleo.whaleclub4j.rest.responses;

public class Balance {
    // Balance available to trade, in satoshis.
    private long available_amount;

    // Total balance, in satoshis.
    private long total_amount;

    // Deposit amount that has not yet confirmed, in satoshis.
    private long unconfirmed_amount;

    // Your deposit address.
    private String deposit_address;

    // Balance used in active positions across markets, in satoshis.
    private Amount active_amount;

    // Balance used in pending positions across markets, in satoshis.
    private Amount pending_amount;

    // Balance used in active turbo positions across markets, in satoshis.
    private Amount active_amount_turbo;

    // When your balance was last updated.
    private long last_updated;

    // Base currency.
    private String currency;

    @Override
    public String toString() {
        return "Balance{" +
                "available_amount=" + available_amount +
                ", total_amount=" + total_amount +
                ", unconfirmed_amount=" + unconfirmed_amount +
                ", deposit_address='" + deposit_address + '\'' +
                ", active_amount=" + active_amount +
                ", pending_amount=" + pending_amount +
                ", active_amount_turbo=" + active_amount_turbo +
                ", last_updated=" + last_updated +
                ", currency='" + currency + '\'' +
                '}';
    }
}
