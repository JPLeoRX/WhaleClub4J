package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.rest.responses.Position;
import com.tekleo.whaleclub4j.util.ListUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Update an existing position.
 *
 * PUT https://api.whaleclub.co/v1/position/update/:id
 *
 * This endpoint allows you to update the stop-loss and/or take-profit of an existing pending or active position.
 *
 * If the request is successful, the API will return a 200 (Ok) status code.
 *
 * Response: returns a {@link Position} with updated values
 *
 * EX: Set stop-loss and take-profit on an existing position
 * https://api.whaleclub.co/v1/position/update/22bCNkWhiwxF7qAMs
 *
 * @author Leo Ertuna
 */
public class UpdatePosition implements Request {
    // Id of existing position
    private String id;

    // Optional. Price at which the position will auto-close in case of loss. Must be set if take_profit is not. Set to 0 to remove an existing stop-loss.
    private Double stop_loss;

    // Optional. Set to true to enable the stop loss to trail. Works only if stop_loss is set. Set to 0 to disable trailing.
    private String stop_loss_trailing;

    // Optional. Price at which the position will auto-close in profit. Must be set if stop_loss is not. Set to 0 to remove an existing take-profit.
    private Double take_profit;

    public UpdatePosition(String id) {
        this.id = id;
    }

    public UpdatePosition setStopLoss(Double stop_loss) {
        this.stop_loss = stop_loss;
        return this;
    }

    public UpdatePosition setStopLossTrailing(String stop_loss_trailing) {
        this.stop_loss_trailing = stop_loss_trailing;
        return this;
    }

    public UpdatePosition setTakeProfit(Double take_profit) {
        this.take_profit = take_profit;
        return this;
    }

    @Override
    public Type getType() {
        return Type.PUT;
    }

    @Override
    public String getMethod() {
        return "/position/update";
    }

    @Override
    public List<String> getArguments() {
        return ListUtils.toList(id);
    }

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> params = new HashMap<>();

        if (stop_loss != null)
            params.put("stop_loss", stop_loss.toString());

        if (stop_loss_trailing != null)
            params.put("stop_loss_trailing", stop_loss_trailing);

        if (take_profit != null)
            params.put("take_profit", take_profit.toString());

        return params;

    }
}
