package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Endpoints;
import com.tekleo.whaleclub4j.rest.Request;

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
    private static final String method = "/balance";

    @Override
    public String getUrl() {
        return Endpoints.getUrl(method);
    }
}
