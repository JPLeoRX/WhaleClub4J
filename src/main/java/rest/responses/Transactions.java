package rest.responses;

import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private List<Transaction> list = new ArrayList<>();

    public void add(Transaction transaction) {
        list.add(transaction);
    }

    @Override
    public String toString() {
        return "Transactions: " + list;
    }
}