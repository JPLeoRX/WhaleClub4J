package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.rest.responses.Position;
import com.tekleo.whaleclub4j.util.ListUtils;

import java.util.List;
import java.util.Map;

/**
 * Close one or multiple active positions at market price.
 *
 * PUT https://api.whaleclub.co/v1/position/close/:id(s)
 *
 * :id(s) is a list of one or more comma-separated position IDs.
 *
 * Use this endpoint to close existing active positions at the best available market price.
 *
 * Positions are closed sequentially as they hit our system (not in parallel).
 * If you’re closing a large number of positions at once,
 * the market price may move in the time it takes to close them all.
 * If you’re looking to close at a specific market price,
 * close your positions individually or use a take-profit or stop-loss.
 *
 * If the request is successful, the API will return a 200 (Ok) status code.
 *
 * Response: returns a {@link Position} with updated values
 *
 * EX: Close a 100BTC EUR/USD long position at market price
 * https://api.whaleclub.co/v1/position/close/22bCNkWhiwxF7qAMs
 *
 * @author Leo Ertuna
 */
public class ClosePosition implements Request {
    // List of one or more comma-separated position IDs.
    private List<String> ids;

    public ClosePosition(String ... ids) {
        this.ids = ListUtils.toList(ids);
    }

    @Override
    public Type getType() {
        return Type.PUT;
    }

    @Override
    public String getMethod() {
        return "/position/close";
    }

    @Override
    public List<String> getArguments() {
        return ids;
    }

    @Override
    public Map<String, String> getParameters() {
        return null;
    }
}