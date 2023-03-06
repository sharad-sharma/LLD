package org.example.factory;

import org.example.entities.BalanceSheet;
import org.example.entities.User;

import java.util.List;

public class PercentSplit extends SplitStrategy {
    private final BalanceSheet balanceSheet;
    private final List<Double> percentages;
    public PercentSplit(double amount, User paidBy, List<User> users, BalanceSheet balanceSheet,
                        List<Double> percentages) {
        super(amount, paidBy, users);
        this.balanceSheet = balanceSheet;
        this.percentages = percentages;
    }

    @Override
    public void splitAmount() {
        int numOfUsers = users.size();
        for(int i=0; i<numOfUsers; i++) {
            double percentage = percentages.get(i);
            double userAmount = (percentage * amount) / 100;

            balanceSheet.addTransaction(paidBy, users.get(i), userAmount);
        }
    }
}
