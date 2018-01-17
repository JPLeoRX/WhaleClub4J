package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Request;
import com.tekleo.whaleclub4j.util.ListUtils;
import com.tekleo.whaleclub4j.util.MapUtils;

import java.util.List;
import java.util.Map;

/**
 * List transactions that have occurred on your account.
 *
 * GET https://api.whaleclub.co/v1/transactions/:type
 *
 * Use this endpoint to request a list of transactions.
 * type can be deposits, withdrawals, referrals, or bonuses.
 * Defaults to deposits.
 *
 * Transactions returned are sorted by creation date (created_at).
 *
 * If the request is successful, the API will return a 200 (Ok) status code.
 *
 * EX: List deposits you’ve made to your Whaleclub wallet
 * https://api.whaleclub.co/v1/transactions/deposits
 *
 * @author Leo Ertuna
 */
public class GetTransactions implements Request {
    // Optional. Can be deposits, withdrawals, referrals, or bonuses. Defaults to deposits
    private String type;

    // Optional. Number of results per request. Defaults to 5. Max is 50.
    private String limit;

    public GetTransactions() {
        this(Type.DEPOSITS, "5");
    }

    public GetTransactions(Type type, String limit) {
        this.type = type.name().toLowerCase();
        this.limit = limit;
    }

    @Override
    public Request.Type getType() {
        return Request.Type.GET;
    }

    @Override
    public String getMethod() {
        return "/transactions";
    }

    @Override
    public List<String> getArguments() {
        return ListUtils.toList(type);
    }

    @Override
    public Map<String, String> getParameters() {
        return MapUtils.toMap("limit", limit);
    }

    private static enum Type {
        WITHDRAWALS, REFERRALS, BONUSES, DEPOSITS
    }
}