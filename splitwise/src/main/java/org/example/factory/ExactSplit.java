package org.example.factory;

import org.example.entities.BalanceSheet;
import org.example.entities.User;

import java.util.List;

public class ExactSplit extends SplitStrategy {
    private final BalanceSheet balanceSheet;
    private final List<Double> amounts;

    public ExactSplit(double amount, User paidBy, List<User> users, BalanceSheet balanceSheet,
                      List<Double> amounts) {
        super(amount, paidBy, users);
        this.balanceSheet = balanceSheet;
        this.amounts = amounts;
    }

    @Override
    public void splitAmount() {
        int numOfUsers = users.size();
        for(int i=0; i<numOfUsers; i++) {
            double userAmount = amounts.get(i);
            balanceSheet.addTransaction(paidBy, users.get(i), userAmount);
        }
    }
}
