package com.tekleo.whaleclub4j.rest.requests;

import com.tekleo.whaleclub4j.rest.Endpoints;
import com.tekleo.whaleclub4j.rest.Request;

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
public class GetTransactions extends Request {
    private static final String method = "/transactions";

    // Optional. Can be deposits, withdrawals, referrals, or bonuses. Defaults to deposits
    private String type = Type.DEPOSITS.name().toLowerCase();

    // Optional. Number of results per request. Defaults to 5. Max is 50.
    private String limit = "5";

    public GetTransactions() {
        this(Type.DEPOSITS, "5");
    }

    public GetTransactions(Type type, String limit) {
        this.type = type.name().toLowerCase();
        this.limit = limit;
    }

    @Override
    public String getUrl() {
        return Endpoints.getUrl(method) + "/" + type + "?limit=" + limit;
    }

    private static enum Type {
        WITHDRAWALS, REFERRALS, BONUSES, DEPOSITS
    }
}