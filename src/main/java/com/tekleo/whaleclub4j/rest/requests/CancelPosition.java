package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.rest.responses.PositionCancelled;
import com.tekleo.whaleclub4j.util.ListUtils;

import java.util.List;
import java.util.Map;

/**
 * Cancel one or multiple pending positions.
 *
 * PUT https://api.whaleclub.co/v1/position/cancel/:id(s)
 *
 * :id(s) is a list of one or more comma-separated position IDs.
 *
 * This endpoint allows you to cancel limit or stop orders that haven’t yet executed.
 * Once cancelled, your positions will be deleted and will no longer be accessible.
 *
 * If the request is successful, the API will return a 200 (Ok) status code.
 *
 * Response: returns a {@link PositionCancelled}
 *
 * EX: Cancel a pending position
 * https://api.whaleclub.co/v1/position/cancel/d7gAxDSeLtdYtZsEd
 *
 * @author Leo Ertuna
 */
public class CancelPosition implements Request {
    // List of one or more comma-separated position IDs.
    private List<String> ids;

    public CancelPosition(String ... ids) {
        this.ids = ListUtils.toList(ids);
    }

    @Override
    public Type getType() {
        return Type.PUT;
    }

    @Override
    public String getMethod() {
        return "/position/cancel";
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