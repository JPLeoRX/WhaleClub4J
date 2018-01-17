package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.rest.responses.Position;
import com.tekleo.whaleclub4j.util.ListUtils;

import java.util.List;
import java.util.Map;

/**
 * Fetch information about an existing position.
 *
 * GET https://api.whaleclub.co/v1/position/:id
 *
 * If the request is successful, the API will return a 200 (Ok) status code.
 *
 * Response: returns a {@link Position}
 *
 * EX: Fetch an existing position by passing its id to the request
 * https://api.whaleclub.co/v1/position/s6pGQ4nyS4Z7jHRvJ
 *
 * @author Leo Ertuna
 */
public class GetPosition implements Request {
    // Id of existing position
    private String id;

    public GetPosition(String id) {
        this.id = id;
    }

    @Override
    public Type getType() {
        return Type.GET;
    }

    @Override
    public String getMethod() {
        return "/position";
    }

    @Override
    public List<String> getArguments() {
        return ListUtils.toList(id);
    }

    @Override
    public Map<String, String> getParameters() {
        return null;
    }
}