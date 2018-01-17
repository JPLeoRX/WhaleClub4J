package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.util.ListUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Submit a new position.
 *
 * POST https://api.whaleclub.co/v1/position/new
 *
 * This endpoint allows you to submit a new position.
 *
 * To submit a limit or stop order, set the entry_price parameter in your request.
 * We’ll automatically detect whether it’s a limit order or a stop order based on the current market price.
 *
 * To submit a market order, simply omit the entry_price parameter from your request.
 * Your order will execute at the best available price.
 *
 * If the request is successful, the API will return a 201 (Created) status code.
 *
 * EX: Open a 100BTC EUR/USD long position at market price, with a stop-loss and take-profit
 * https://api.whaleclub.co/v1/position/new
 *
 * @author Leo Ertuna
 */
public class NewPosition implements Request {
    // Required. Can be long or short.
    private String direction;

    // Required.
    private String market;

    // Required.
    private Double leverage;

    // Required. Your position’s size, in satoshis. This is the total size including leverage, not the margin size.
    private Long size;

    // Optional. Set this to submit a limit/stop order. If omitted, your position will execute at the best available market price.
    private Double entry_price;

    // Optional. Price at which your position will auto-close in case of loss.
    private Double stop_loss;

    // Optional. Set to true to enable the stop loss to trail. Works only if stop_loss is set.
    private Boolean stop_loss_trailing;

    // Optional. Price at which your position will auto-close in profit.
    private Double take_profit;

    public NewPosition(String direction, String market, double leverage, long size) {
        this.direction = direction;
        this.market = market;
        this.leverage = leverage;
        this.size = size;
    }

    public NewPosition setEntryPrice(Double entry_price) {
        this.entry_price = entry_price;
        return this;
    }

    public NewPosition setStopLoss(Double stop_loss) {
        this.stop_loss = stop_loss;
        return this;
    }

    public NewPosition setStopLossTrailing(Boolean stop_loss_trailing) {
        this.stop_loss_trailing = stop_loss_trailing;
        return this;
    }

    public NewPosition setTakeProfit(Double take_profit) {
        this.take_profit = take_profit;
        return this;
    }

    @Override
    public Type getType() {
        return Type.POST;
    }

    @Override
    public String getMethod() {
        return "/position/new";
    }

    @Override
    public List<String> getArguments() {
        return null;
    }

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> params = new HashMap<>();
        params.put("direction", direction);
        params.put("market", market);
        params.put("leverage", leverage.toString());
        params.put("size", size.toString());

        if (entry_price != null)
            params.put("entry_price", entry_price.toString());

        if (stop_loss != null)
            params.put("stop_loss", stop_loss.toString());

        if (stop_loss_trailing != null)
            params.put("stop_loss_trailing", stop_loss_trailing.toString());

        if (take_profit != null)
            params.put("take_profit", take_profit.toString());

        return params;
    }
}
