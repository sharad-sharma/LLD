package org.example.factory;

import org.example.entities.BalanceSheet;
import org.example.entities.User;
import org.example.enums.SplitType;

import java.util.List;

public final class SplitExpenseFactory {

    public static SplitStrategy getSplitExpenseStrategy (SplitType splitType,
                                                         User paidBy, double amount,
                                                         List<User> users, BalanceSheet balanceSheet,
                                                         List<Double> strategyValue) {
        if(splitType.equals(SplitType.EQUAL)) {
            return new EqualSplit(amount, paidBy, users, balanceSheet);
        } else if(splitType.equals(SplitType.EXACT)) {
            return new ExactSplit(amount, paidBy, users, balanceSheet, strategyValue);
        } else {
            return new PercentSplit(amount, paidBy, users, balanceSheet, strategyValue);
        }
    }
}
