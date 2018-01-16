package com.tekleo.whaleclub4j.rest.responses;

public class Transaction {
    // Unique ID for the transaction.
    private String id;

    // Value of the transaction, in satoshis.
    private long amount;

    // Can be pending or complete. Appears only for deposits and withdrawals.
    private String state;

    // Bitcoin transaction hash. Appears only for deposits.
    private String hash;

    // Destination Bitcoin address. Appears only for withdrawals.
    private String address;

    // When the transaction was made.
    private long created_at;

    // Base currency.
    private String currency;

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", state='" + state + '\'' +
                ", hash='" + hash + '\'' +
                ", address='" + address + '\'' +
                ", created_at=" + created_at +
                ", currency='" + currency + '\'' +
                '}';
    }
}