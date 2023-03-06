package org.example.services;

import org.example.entities.BalanceSheet;
import org.example.entities.Expense;
import org.example.entities.User;
import org.example.enums.SplitType;
import org.example.factory.SplitExpenseFactory;
import org.example.factory.SplitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* It manages Expenses */
public class SplitwiseService {
    private final List<User> users;
    private final List<Expense> expenses;
    BalanceSheet balanceSheet;


    public SplitwiseService(List<User> users, BalanceSheet balanceSheet) {
        this.users = users;
        this.balanceSheet = balanceSheet;

        expenses = new ArrayList<>();
    }

    public void addExpense(User paidBy, double amount, SplitType splitType, List<User> users,
                    List<Double> strategyValues) {
        SplitStrategy splitStrategy = SplitExpenseFactory.getSplitExpenseStrategy(splitType,
                paidBy, amount, users, balanceSheet, strategyValues);

        Expense expense = new Expense("id", amount, paidBy, splitStrategy);
        expense.performSplit();

        expenses.add(expense);
    }

    public void printBalance(User user) {
        Map<User, Double> balanceHistories = balanceSheet.getUserBalanceHistory(user);

        for(User to: users) {
            if(balanceHistories.containsKey(to)) {
                Double amountToUser = balanceHistories.get(to);

                if(amountToUser < 0) {
                    System.out.println(user.getName() + " owes " + amountToUser + " Rupees to user " +
                           to.getName() );
                } else if(amountToUser > 0) {
                    System.out.println(to.getName() + " owes " + amountToUser + " Rupees to user " +
                            user.getName() );
                }
            }
        }
    }

    public void printBalance() {
        for(User fromUser: users) {
            Map<User, Double> balanceHistories = balanceSheet.getUserBalanceHistory(fromUser);
            if(balanceHistories == null) continue;
            for(User toUser: users) {
                if(fromUser == toUser || !balanceHistories.containsKey(toUser)) continue;

                double amountToUser = balanceHistories.get(toUser);

                if(amountToUser > 0) {
                    System.out.println(toUser.getName() + " owes " + amountToUser + " Rupees to user " +
                            fromUser.getName() );
                }
            }
        }
    }
}
