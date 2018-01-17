package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;

import java.util.List;
import java.util.Map;

/**
 * Returns information about your balance.
 *
 * GET https://api.whaleclub.co/v1/balance
 *
 * Real or demo balance information will be returned based on whether you use your live or demo API token.
 *
 * EX: Request information about your current balance
 * https://api.whaleclub.co/v1/balance
 *
 * @author Leo Ertuna
 */
public class GetBalance implements Request {
    @Override
    public Type getType() {
        return Type.GET;
    }

    @Override
    public String getMethod() {
        return "/balance";
    }

    @Override
    public List<String> getArguments() {
        return null;
    }

    @Override
    public Map<String, String> getParameters() {
        return null;
    }
}