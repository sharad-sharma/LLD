package org.example.factory;

import org.example.entities.BalanceSheet;
import org.example.entities.User;

import java.util.List;

public class EqualSplit extends SplitStrategy {
    private final BalanceSheet balanceSheet;
    public EqualSplit(double amount, User paidBy, List<User> users, BalanceSheet balanceSheet) {
        super(amount, paidBy, users);
        this.balanceSheet = balanceSheet;
    }

    @Override
    public void splitAmount() {
        int numberOfUsers = users.size();

        double amountPerUser = amount / numberOfUsers;

        for(User user: users) {
            if(user == paidBy) continue;
            balanceSheet.addTransaction(paidBy, user, amountPerUser);
        }
    }
}
