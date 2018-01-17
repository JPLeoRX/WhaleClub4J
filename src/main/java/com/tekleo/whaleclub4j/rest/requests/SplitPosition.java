package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.rest.responses.Position;
import com.tekleo.whaleclub4j.util.ListUtils;
import com.tekleo.whaleclub4j.util.MapUtils;

import java.util.List;
import java.util.Map;

/**
 * Split an existing pending or active position.
 *
 * POST https://api.whaleclub.co/v1/position/split/:id
 *
 * This endpoint allows you to split an existing position according to a ratio you provide.
 * It can only be called on a pending or active position.
 *
 * If the request is successful, the API will return a 200 (Ok) status code.
 *
 * Response: array of {@link Position} containing two smaller positions resulting from the split
 *
 * @author Leo Ertuna
 */
public class SplitPosition implements Request {
    // Id of existing position
    private String id;

    // Required. In percent. Must be between 5 and 95.
    private Integer ratio;

    public SplitPosition(String id, Integer ratio) {
        this.id = id;
        this.ratio = ratio;
    }

    @Override
    public Type getType() {
        return Type.POST;
    }

    @Override
    public String getMethod() {
        return "/position/split";
    }

    @Override
    public List<String> getArguments() {
        return ListUtils.toList(id);
    }

    @Override
    public Map<String, String> getParameters() {
        return MapUtils.toMap("ratio", ratio.toString());
    }
}