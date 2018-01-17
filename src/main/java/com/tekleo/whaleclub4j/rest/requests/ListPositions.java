package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.rest.responses.Position;
import com.tekleo.whaleclub4j.util.ListUtils;
import com.tekleo.whaleclub4j.util.MapUtils;
import org.omg.PortableInterceptor.ACTIVE;

import java.util.List;
import java.util.Map;

/**
 * List positions.
 *
 * GET https://api.whaleclub.co/v1/positions/:state
 *
 * Use this endpoint to request a list of positions.
 * state can be pending, active, or closed. Defaults to active.
 *
 * It’s strongly recommended that you maintain your own list of positions,
 * and use the Price endpoint to keep it updated instead of polling this endpoint
 * to track the state of your positions.
 *
 * Pending positions are sorted by created_at,
 * active positions are sorted by entered_at,
 * and closed positions are sorted by closed_at.
 *
 * If the request is successful, the API will return a 200 (Ok) status code.
 *
 * Response: array of {@link Position}
 *
 * @author Leo Ertuna
 */
public class ListPositions implements Request {
    // State can be pending, active, or closed. Defaults to active.
    private String state;

    //  Optional. Number of results per request. Defaults to 5. Max is 30.
    private Integer limit;

    public ListPositions() {
        this(State.ACTIVE);
    }

    public ListPositions(State state) {
        this.state = state.name().toLowerCase();
    }

    public ListPositions setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public Type getType() {
        return Type.GET;
    }

    @Override
    public String getMethod() {
        return "/positions";
    }

    @Override
    public List<String> getArguments() {
        return ListUtils.toList(state);
    }

    @Override
    public Map<String, String> getParameters() {
        if (limit != null)
            return MapUtils.toMap("limit", limit.toString());

        return null;
    }

    private static enum State {
        PENDING, ACTIVE, CLOSED
    }
}