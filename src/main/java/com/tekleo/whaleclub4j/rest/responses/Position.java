package com.tekleo.whaleclub4j.rest.responses;

public class Position {
    // Unique ID for the position.
    private String id;

    // ID of parent position. Appears only if this position has been split.
    private String parent_id;

    // A URL-friendly position identifier. Your position can be shared publicly at https://whaleclub.co/position/:slug
    private String slug;

    // Can be long or short.
    private String direction;

    // Market this position was executed on.
    private String market;

    // Position’s leverage level.
    private long leverage;

    // Order type. Can be market, limit, or stop
    private String type;

    // Can be pending, active, or closed
    private String state;

    // Position’s size, in satoshis.
    private long size;

    // Position’s margin size, in satoshis.
    private long margin_size;

    // Price at which the position was executed (if at market) or will execute (if limit or stop).
    private double entry_price;

    // Price at which the position will auto-close in case of loss. Appears only if the position’s stop-loss is set.
    private double stop_loss;

    // Returns {set: true} if the stop loss is a trailing stop loss.
    private StopLossTrading stop_loss_trading;

    // Price at which the position will auto-close in profit. Appears only if the position’s take-profit is set.
    private double take_profit;

    // How the position was closed. Can be at_market, at_stop, at_target, or liquidation. Appears only if the position is closed.
    private String close_reason;

    // Price at which the position was closed. Appears only if the position is closed.
    private double close_price;

    // Profit made on the trade, in satoshis. Negative in case of loss. Appears only if the position is closed.
    private long profit;

    //  When the position was created.
    private long created_at;

    // When the position was executed. Appears only if the position is active or closed.
    private long entered_at;

    // When the position was closed. Appears only if the position is closed.
    private long closed_at;

    // When the position’s stop-loss and/or take-profit was last updated. Appears only if the position is manually updated after it’s been submitted.
    private long last_updated;

    // Price at which the position will auto-close to cover your margin in case of loss.
    private double liquidation_price;

    // Leverage financing charged on the position, in satoshis. Appears only if the position is active or closed.
    private long financing;

    // Base currency.
    private String currency;
}